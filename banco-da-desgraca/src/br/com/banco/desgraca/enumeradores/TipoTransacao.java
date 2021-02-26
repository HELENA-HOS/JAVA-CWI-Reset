package br.com.banco.desgraca.enumeradores;

public enum TipoTransacao {
    SAQUE('-',"(SAQ)"),
    TRANSFERENCIA('-', "(TRANSF)"),
    TAXA('-',"(TAX)"),
    DEPOSITO('+',"(DEP)");


    private char sinal;
    private String operacao;

    TipoTransacao(char sinal, String operacao) {
        this.sinal = sinal;
        this.operacao = operacao;
    }

    public char getSinal() {
        return sinal;
    }

    public String getOperacao() {
        return operacao;
    }
}
