package support.informatica.api.teste.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Produto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal preco;

    private BigDecimal quantidade;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();

    }

    public void atualizarDados(DadosAtualizacaoProduto dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.preco() != null){
            this.preco = dados.preco();
        }

        if (dados.quantidade() != null){
            this.quantidade = dados.quantidade();
        }
    }
}
