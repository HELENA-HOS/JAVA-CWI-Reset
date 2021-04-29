package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.*;
import br.com.cwi.reset.tcc.repository.*;
import br.com.cwi.reset.tcc.request.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PedidoMapper {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    ItemPedidoMapper itemPedidoMapper;


    public Pedido mapear(PedidoRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuarioSolicitante()).orElse(null);
        Endereco endereco = enderecoRepository.findById(request.getIdEnderecoEntrega()).orElse(null);
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(request.getIdEstabelecimento()).orElse(null);
        List<ItemPedido> itensPedido = itemPedidoMapper.mapearLista(request.getItens());


        return new Pedido(usuario, endereco, estabelecimento,itensPedido, request.getFormaPagamento());
    }
}

