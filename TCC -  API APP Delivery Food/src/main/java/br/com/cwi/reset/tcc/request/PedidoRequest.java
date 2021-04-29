package br.com.cwi.reset.tcc.request;

import br.com.cwi.reset.tcc.dominio.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PedidoRequest {

    private Long idEstabelecimento;

    private Long idUsuarioSolicitante;

    private Long idEnderecoEntrega;

    private FormaPagamento formaPagamento;

    private List<ItemPedidoRequest> itens;
}
