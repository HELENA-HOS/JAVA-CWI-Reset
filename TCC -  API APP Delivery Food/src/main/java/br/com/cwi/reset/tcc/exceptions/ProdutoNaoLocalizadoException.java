package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNaoLocalizadoException extends RuntimeException {
    public ProdutoNaoLocalizadoException() {
        super("Código de produto não localizado.");
    }
}
