package br.com.cwi.reset.tcc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstabelecimentoFechadoException extends RuntimeException {
    public EstabelecimentoFechadoException() {
        super("Estabelecimento fechado. Não é possível fazer pedidos fora do horário de funcionamento.");
    }
}
