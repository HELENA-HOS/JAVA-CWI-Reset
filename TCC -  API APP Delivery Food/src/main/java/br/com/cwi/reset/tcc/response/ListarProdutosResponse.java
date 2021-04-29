package br.com.cwi.reset.tcc.response;

import br.com.cwi.reset.tcc.dominio.Categoria;
import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ListarProdutosResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private BigDecimal valor;

    private String urlFoto;

    private Categoria categoria;

    private Integer tempoPreparo;

    private Estabelecimento estabelecimento;

}
