package br.com.cwi.reset.tcc.mapper;


import br.com.cwi.reset.tcc.dominio.ItemPedido;
import br.com.cwi.reset.tcc.dominio.Produto;
import br.com.cwi.reset.tcc.repository.ProdutoRepository;
import br.com.cwi.reset.tcc.request.ItemPedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemPedidoMapper {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ItemPedido> mapearLista(List <ItemPedidoRequest> request) {

        List<ItemPedido> itemPedidos = new ArrayList<>();

        for(ItemPedidoRequest itemPedidoRequest : request) {
            Produto produto = produtoRepository.findById(itemPedidoRequest.getIdProduto()).orElse(null);

            ItemPedido itemPedido = new ItemPedido(produto, itemPedidoRequest.getQuantidade());

            itemPedidos.add(itemPedido);
        }

        return itemPedidos;
    }
}
