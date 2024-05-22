package support.informatica.api.teste.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        BigDecimal preco,
        BigDecimal quantidade) {
}
