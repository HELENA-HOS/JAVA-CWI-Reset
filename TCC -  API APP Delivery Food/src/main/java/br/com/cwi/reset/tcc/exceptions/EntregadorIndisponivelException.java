package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntregadorIndisponivelException extends RuntimeException {
    public EntregadorIndisponivelException() {
        super("Não há entregador disponível para essa entrega. Tente novamente mais tarde.");
    }
}
