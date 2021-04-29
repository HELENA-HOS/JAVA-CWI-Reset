package br.com.cwi.reset.tcc.response;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
public class NovoPedidoResponse {

    private Long idPedido;

    private Integer tempoEstimadoEmMinutos;

    private BigDecimal valorTotal;

    private StatusPedido statusPedido;

    private Endereco enderecoEntrega;
}
