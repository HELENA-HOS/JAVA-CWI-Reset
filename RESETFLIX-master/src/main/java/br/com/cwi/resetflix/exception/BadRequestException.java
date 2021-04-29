package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class BadRequestException extends HttpStatusCodeException {

    private static final long serialVersionUID = -3010619279952740729L;

    static HttpStatus status = HttpStatus.BAD_REQUEST;

    public BadRequestException(final String statusText) {
        super(status, statusText);
    }
}

