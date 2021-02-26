package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Data;
import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.ValorInvalidoException;


public class ContaCorrente extends Conta {
    private static final Double taxa = 0.01;


    public ContaCorrente(String numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
        if (contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()) {
        }
        setSaldo(getSaldo() - (valor * this.taxa));
        getTransacoes().add(new Transacao(TipoTransacao.TAXA,Data.getDataTransacao(), (valor * this.taxa)));
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return null;
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        if(valor % 5 !=0) {
            throw new ValorInvalidoException("Valor para saque inválido!");
        }
    }
}





