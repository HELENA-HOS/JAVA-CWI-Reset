package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException(String message) {
        super(message);
    }
}
