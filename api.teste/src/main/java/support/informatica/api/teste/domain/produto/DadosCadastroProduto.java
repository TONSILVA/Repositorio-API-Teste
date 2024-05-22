package support.informatica.api.teste.domain.produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank
        String nome,

        @NotNull
        @DecimalMin("0.00")
        BigDecimal preco,

        @NotNull
        @DecimalMin("0.00")
        BigDecimal quantidade) {

}
