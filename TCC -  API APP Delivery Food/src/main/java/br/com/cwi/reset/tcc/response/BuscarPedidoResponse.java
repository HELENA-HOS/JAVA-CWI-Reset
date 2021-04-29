package br.com.cwi.reset.tcc.response;

import br.com.cwi.reset.tcc.dominio.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BuscarPedidoResponse {

    private String nomeSolicitante;

    private EnderecoEntregaResponse enderecoEntrega;

    private String nomeEstabelecimento;

    private List<ItemPedidoResponse> itensPedido;

    private BigDecimal valorTotal;

    private Entregador entregador;

    private LocalDateTime horarioPrevistoParaEntrega;

    private String situacao;

}
