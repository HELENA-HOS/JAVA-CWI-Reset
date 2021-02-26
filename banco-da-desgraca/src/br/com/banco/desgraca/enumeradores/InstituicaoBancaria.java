package br.com.banco.desgraca.enumeradores;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL("Banco do Brasil"),
    BRADESCO("Bradesco"),
    CAIXA("Caixa Econômica Fed."),
    ITAU("Itaú"),
    NUBANK("Nubank");

    private String banco;


    InstituicaoBancaria(String banco) {
        this.banco = banco;
    }


    public String getBanco() {
        return banco;
    }
}
