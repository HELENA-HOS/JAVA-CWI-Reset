package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.enumeradores.TipoTransacao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipo;
    private LocalDate data;
    private Double valorDaTransacao;

    public Transacao(TipoTransacao tipo, LocalDate data, Double valorDaTransacao) {
        this.tipo = tipo;
        this.data = data;
        this.valorDaTransacao = valorDaTransacao;
    }

    public void exibirTransacoes() {
        String valorFormatado = DecimalFormat.getCurrencyInstance().format(valorDaTransacao);
        System.out.println(tipo.getSinal() + " " + tipo.getOperacao() + " " + valorFormatado + " " + getData().format(DateTimeFormatter.ofPattern("dd-MM-yy")));
    }


    public LocalDate getData() {
        return data;
    }


}
