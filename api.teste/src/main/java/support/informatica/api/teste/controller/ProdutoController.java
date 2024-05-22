package support.informatica.api.teste.controller;

import support.informatica.api.teste.domain.produto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dados);
        repository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listar(Pageable paginacao){

        var page =  repository.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados){
    var produto = repository.getReferenceById(dados.id());
    produto.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id ){
    repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
       public ResponseEntity detalhar(@PathVariable Long id ){
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }
}
