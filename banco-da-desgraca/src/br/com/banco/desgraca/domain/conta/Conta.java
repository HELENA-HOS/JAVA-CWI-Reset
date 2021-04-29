package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Data;
import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaBancaria {
    private String numeroDaConta;
    private InstituicaoBancaria banco;
    private Double saldo;
    private List<Transacao> transacoes = new ArrayList<Transacao>();


    public Conta(String numeroDaConta, InstituicaoBancaria banco) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = 0d;
    }

    @Override
    public String toString() {
        return banco.getBanco() + " " + numeroDaConta;
    }

    public InstituicaoBancaria getBanco() {
        return banco;
    }


    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public Double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        saldo = valor + saldo;
        transacoes.add(new Transacao(TipoTransacao.DEPOSITO, Data.getDataTransacao(), valor));
        System.out.println("Depositando valor " + DecimalFormat.getCurrencyInstance().format(valor) + " na conta " + this.toString());
    }

    @Override
    public void sacar(Double valor) {
        validaSaldo(valor);
        saldo = saldo - valor;
        getTransacoes().add(new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
        System.out.println("Sacando o valor " + DecimalFormat.getCurrencyInstance().format(valor) + " da conta " + this.toString());
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validaSaldo(valor);
        saldo = saldo - valor;
        getTransacoes().add(new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
        System.out.println("Transferindo o valor " + DecimalFormat.getCurrencyInstance().format(valor) + " da conta " + this.toString() +
                " para conta " + contaDestino.toString());

    }

    public void validaSaldo(Double valor) {
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }


    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("\n----- EXTRATO " + this.toString() + " -----");



        for (Transacao transacao : transacoes) {
            transacao.exibirTransacoes();
        }
        System.out.println("--> SALDO: " + DecimalFormat.getCurrencyInstance().format(saldo) + "\n");
    }
}
