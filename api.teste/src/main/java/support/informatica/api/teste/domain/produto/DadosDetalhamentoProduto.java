package support.informatica.api.teste.domain.produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(Long id, String nome, BigDecimal preco, BigDecimal quantidade) {

    public DadosDetalhamentoProduto(Produto produto) {
       this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }
}
