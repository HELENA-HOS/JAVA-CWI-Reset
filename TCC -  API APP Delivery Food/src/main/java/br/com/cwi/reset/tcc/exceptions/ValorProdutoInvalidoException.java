package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValorProdutoInvalidoException extends RuntimeException{
    public ValorProdutoInvalidoException() {
        super("Valor do produto deve ser maior que 0 (zero).");
    }
}
