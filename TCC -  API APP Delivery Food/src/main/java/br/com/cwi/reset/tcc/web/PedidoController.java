package br.com.cwi.reset.tcc.web;


import br.com.cwi.reset.tcc.request.PedidoRequest;
import br.com.cwi.reset.tcc.response.BuscarPedidoResponse;
import br.com.cwi.reset.tcc.response.EntregadorEntregaResponse;
import br.com.cwi.reset.tcc.response.NovoPedidoResponse;
import br.com.cwi.reset.tcc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NovoPedidoResponse cadastrarPedido(@RequestBody PedidoRequest request){
        return pedidoService.cadastrarPedido(request);
    }

    @GetMapping("/{id}")
    public BuscarPedidoResponse buscarPedidoPorId(@PathVariable("id") Long id){
        return pedidoService.buscarPedidoPorId(id);
    }

    @PutMapping("/{id}/entregar")
    public EntregadorEntregaResponse entregarPedidoEntregador(@PathVariable("id") Long id){
        return pedidoService.entregarPedidoEntregador(id);
    }

    @PutMapping("/{id}/finalizar")
    public void finalizarPedido(@PathVariable("id") Long id){
        pedidoService.finalizarPedido(id);
    }

    @DeleteMapping("/{id}")
    public void cancelarPedido(@PathVariable("id") Long id){
        pedidoService.cancelarPedido(id);
    }

}
