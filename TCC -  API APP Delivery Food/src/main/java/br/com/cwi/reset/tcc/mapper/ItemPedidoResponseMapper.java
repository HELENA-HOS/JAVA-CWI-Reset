package br.com.cwi.reset.tcc.mapper;


import br.com.cwi.reset.tcc.dominio.ItemPedido;
import br.com.cwi.reset.tcc.response.ItemPedidoResponse;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemPedidoResponseMapper {

    public List<ItemPedidoResponse> mapearLista(List <ItemPedido> itemPedidoSalvo) {

        List<ItemPedidoResponse> itemPedidosResponses = new ArrayList<>();

        for(ItemPedido itemPedido : itemPedidoSalvo) {

            ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse(itemPedido.getProduto().getTitulo(),
                    itemPedido.getQuantidade());

            itemPedidosResponses.add(itemPedidoResponse);
        }

        return itemPedidosResponses;
    }
}
