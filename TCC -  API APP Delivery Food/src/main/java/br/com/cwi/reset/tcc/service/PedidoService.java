package br.com.cwi.reset.tcc.service;

import br.com.cwi.reset.tcc.dominio.*;
import br.com.cwi.reset.tcc.exceptions.*;
import br.com.cwi.reset.tcc.mapper.ItemPedidoResponseMapper;
import br.com.cwi.reset.tcc.mapper.PedidoMapper;
import br.com.cwi.reset.tcc.repository.*;
import br.com.cwi.reset.tcc.request.ItemPedidoRequest;
import br.com.cwi.reset.tcc.request.PedidoRequest;
import br.com.cwi.reset.tcc.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ItemPedidoResponseMapper itemPedidoResponseMapper;




    // ------ ***** METÓDO CRIAR PEDIDO ***** ------ //


    public NovoPedidoResponse cadastrarPedido(PedidoRequest request){
        validaPedido(request);

        Pedido pedido = pedidoMapper.mapear(request);

        pedido.setHorarioSolicitacao(LocalDateTime.now());
        validaHorarioFuncionamento(pedido);

        validaQuantidadeProduto(pedido);

        pedido.setValorTotal(calcularValorTotal(pedido));
        pedido.setStatus(StatusPedido.EM_PREPARO);

        pedidoRepository.save(pedido);
        return novoPedido(pedido);
    }

    // ------ ***** METÓDOS AUXILIARES CRIAR PEDIDO ***** ------ //

    public void validaPedido(PedidoRequest request){
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(request.getIdEstabelecimento()).orElseThrow(()
                -> new EstabelecimentoNaoLocalizadoException());
        Usuario usuario = usuarioRepository.findById(request.getIdUsuarioSolicitante()).orElseThrow(()
                -> new UsuarioNaoLocalizadoException());
        if(usuario.getEnderecos() == null || usuario.getEnderecos().isEmpty()) {
            throw new UsuarioEnderecoInvalidoException();
        }
        if(!estabelecimento.getFormasPagamento().contains(request.getFormaPagamento())){
            throw new FormadePagamentoInvalidaException();
        }

        List<ItemPedidoRequest> itensPedidos = request.getItens();

        for(ItemPedidoRequest itemPedidoRequest : itensPedidos) {
            Produto produto = produtoRepository.findById(itemPedidoRequest.getIdProduto()).orElse(null);

            if(produto.getEstabelecimento().getId() != request.getIdEstabelecimento()){
                throw new ItemIndisponivelException();
            }
        }
        Endereco endereco = enderecoRepository.findById(request.getIdEnderecoEntrega()).orElseThrow(()
                    -> new EnderecoNaoLocalizadoException());
        if(!usuario.getEnderecos().contains(endereco)) {
                throw new UsuarioEnderecoInvalidoException();
            }
    }



    public void validaQuantidadeProduto(Pedido pedido){
        List<ItemPedido> itensPedidos = pedido.getItensPedido();
        for(ItemPedido itemPedido : itensPedidos) {
            if(itemPedido.getQuantidade() > 5) {
                throw new QuantidadeProdutoException();
            }
        }
    }


    public void validaHorarioFuncionamento(Pedido pedido) {

        LocalTime horaPedido = pedido.getHorarioSolicitacao().toLocalTime();
        DayOfWeek diaSemana = pedido.getHorarioSolicitacao().getDayOfWeek();

        List<HorarioFuncionamento> horarioEstabelecimento = pedido.getEstabelecimento().getHorariosFuncionamento();

        for(HorarioFuncionamento horarioFuncionamento : horarioEstabelecimento) {
            if(diaSemana.equals(horarioFuncionamento.getDiaSemana())){
                LocalTime horarioAbertura = horarioFuncionamento.getHorarioAbertura();
                LocalTime horarioFechamento = horarioFuncionamento.getHorarioFechamento();

                if(horaPedido.isBefore(horarioAbertura) || horaPedido.isAfter(horarioFechamento)){
                    throw new EstabelecimentoFechadoException();
                }
            }
        }
    }


    public NovoPedidoResponse novoPedido(Pedido pedido) {
        Integer tempoEstimadoEmMinutos = calcularTempoestimado(pedido);

        NovoPedidoResponse novoPedidoResponse = new NovoPedidoResponse(pedido.getId(),tempoEstimadoEmMinutos,
                pedido.getValorTotal(),pedido.getStatus(),pedido.getEnderecoEntrega());

        return novoPedidoResponse;
    }


    public Integer calcularTempoestimado(Pedido pedido){

        List<ItemPedido> itens = pedido.getItensPedido();
        Integer tempo = 0;

        for(ItemPedido itemPedido: itens){
            Produto produto = produtoRepository.findById(itemPedido.getProduto().getId()).orElse(null);
            tempo += produto.getTempoPreparo() * itemPedido.getQuantidade();
        }
        return tempo;
    }


    public BigDecimal calcularValorTotal(Pedido pedido){

        List<ItemPedido> itens = pedido.getItensPedido();
        Double valor = 0d;

        for(ItemPedido itemPedido: itens){
            Produto produto = produtoRepository.findById(itemPedido.getProduto().getId()).orElse(null);
            valor += ((BigDecimal)produto.getValor()).doubleValue() * itemPedido.getQuantidade().doubleValue();
        }
        return BigDecimal.valueOf(valor).setScale(2, BigDecimal.ROUND_UP);
    }


    // ------ ***** METÓDO BUSCAR PEDIDO POR ID ***** ------ //


    public BuscarPedidoResponse buscarPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()
                -> new PedidoNaoLocalizadoException());

        Endereco endereco = enderecoRepository.findById(pedido.getEnderecoEntrega().getId()).orElse(null);
        EnderecoEntregaResponse enderecoEntrega = new EnderecoEntregaResponse(endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado());

        List<ItemPedidoResponse> itensPedido = itemPedidoResponseMapper.mapearLista(pedido.getItensPedido());

        Long tempoEstimadoemMinutos = Long.valueOf(calcularTempoestimado(pedido));
        LocalDateTime horarioPrevistoParaEntrega = pedido.getHorarioSolicitacao().plus(tempoEstimadoemMinutos, ChronoUnit.MINUTES);

        if(pedido.getStatus()==StatusPedido.ENTREGUE){
            horarioPrevistoParaEntrega = null;
        }

        return new BuscarPedidoResponse(pedido.getSolicitante().getNome(),enderecoEntrega,
                pedido.getEstabelecimento().getNomeFantasia(),itensPedido,pedido.getValorTotal(),pedido.getEntregador(), horarioPrevistoParaEntrega,pedido.getStatus().getDescricao());
    }

    // ------ ***** METÓDO ENTREGAR PEDIDO P/ ENTREGADOR ***** ------ //


    public EntregadorEntregaResponse entregarPedidoEntregador(Long id) {
        Entregador entregadorDisponivel = entregadorRepository.findFirstByDisponivelTrue().orElseThrow(()
                -> new EntregadorIndisponivelException());

        EntregadorEntregaResponse entregadorEntrega = new EntregadorEntregaResponse(entregadorDisponivel.getId(),
                entregadorDisponivel.getCpf(),
                entregadorDisponivel.getNome(),
                entregadorDisponivel.getTelefone(),
                entregadorDisponivel.getPlacaVeiculo());

        Pedido pedido = pedidoRepository.findById(id).orElse(null);

        if(pedido.getStatus() != StatusPedido.EM_PREPARO){
            throw new PedidoForaDeStatusException("Pedido precisa estar *EM PREPARO* para sair para entrega.");
        }

        pedido.setEntregador(entregadorDisponivel);
        pedido.setHorarioSaiuParaEntrega(LocalDateTime.now());
        pedido.setStatus(StatusPedido.SAIU_PARA_ENTREGA);
        entregadorDisponivel.setDisponivel(false);
        pedidoRepository.save(pedido);
        return entregadorEntrega;

    }

    // ------ ***** METÓDO FINALIZAR PEDIDO ***** ------ //

    public void finalizarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);

        if(pedido.getStatus() != StatusPedido.SAIU_PARA_ENTREGA){
            throw new PedidoForaDeStatusException("Pedido precisa estar como *SAIU PARA ENTREGA* para ser finalizado.");
        }
        pedido.setStatus(StatusPedido.ENTREGUE);
        pedido.setHorarioEntrega(LocalDateTime.now());
        pedido.getEntregador().setDisponivel(true);
        pedidoRepository.save(pedido);
    }

    // ------ ***** METÓDO FINALIZAR PEDIDO ***** ------ //

    public void cancelarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);

        if(pedido.getStatus() != StatusPedido.EM_PREPARO){
            throw new PedidoForaDeStatusException("Pedido precisa estar *EM PREPARO* para ser cancelado.");
        }

        pedido.setHorarioCancelamento(LocalDateTime.now());

        long minutos = ChronoUnit.MINUTES.between(pedido.getHorarioSolicitacao(),pedido.getHorarioCancelamento());
        if(minutos>11){
            throw new CancelamentoPedidoException();
        }

        pedido.setStatus(StatusPedido.CANCELADO);

        pedidoRepository.save(pedido);

    }


}
