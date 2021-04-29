package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstabelecimentoNaoLocalizadoException extends RuntimeException {
    public EstabelecimentoNaoLocalizadoException() {
        super("Código de estabelecimento não localizado.");
    }
}
