package br.com.cwi.reset.tcc.request;


import br.com.cwi.reset.tcc.dominio.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class CriarProdutoRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    private String urlFoto;

    private Categoria categoria;

    private Integer tempoPreparo;

    @NotNull
    private Long idEstabelecimento;
}
