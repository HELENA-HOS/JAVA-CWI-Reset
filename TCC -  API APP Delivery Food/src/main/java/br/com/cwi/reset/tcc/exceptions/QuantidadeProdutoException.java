package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuantidadeProdutoException extends RuntimeException {

    public QuantidadeProdutoException() {
        super("Quantidade máxima de cada produto limitada a 5 unidades.");
    }
}
