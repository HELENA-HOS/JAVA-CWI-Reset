package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CancelamentoPedidoException extends RuntimeException {
    public CancelamentoPedidoException() {
        super("Pedido só pode ser cancelado até 10 minutos após sua solicitação.");
    }
}
