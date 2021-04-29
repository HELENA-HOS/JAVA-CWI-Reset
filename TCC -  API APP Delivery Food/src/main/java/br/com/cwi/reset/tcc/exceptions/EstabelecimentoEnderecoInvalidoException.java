package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstabelecimentoEnderecoInvalidoException extends RuntimeException {
    public EstabelecimentoEnderecoInvalidoException() {
        super("Este endereço não pertence a este estabelecimento");
    }
}
