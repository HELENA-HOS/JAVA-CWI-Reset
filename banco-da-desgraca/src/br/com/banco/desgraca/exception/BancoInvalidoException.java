package br.com.banco.desgraca.exception;

public class BancoInvalidoException extends RuntimeException{

    public BancoInvalidoException(String message) {
        super(message);
    }
}
