package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Data;
import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.BancoInvalidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

public class ContaPoupanca extends Conta{
    private Float taxa;



    public ContaPoupanca(String numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validaBanco(banco);
    }



    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getBanco();
    }

    private void validaBanco(InstituicaoBancaria banco) {
        if(banco.equals(InstituicaoBancaria.NUBANK)){
            throw new BancoInvalidoException("Banco inválido para esse tipo de Conta Bancária");
        }
    }

    public void validaSaque(Double valor){
        if(valor < 50d) {
            throw new ValorInvalidoException("Valor mínimo de R$50,00 para essa operação.");
        } else {
            taxa = (float)  0.020;
            setSaldo(getSaldo() - (valor * this.taxa));
        }
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        validaSaque(valor);
        getTransacoes().add(new Transacao(TipoTransacao.TAXA, Data.getDataTransacao(), (valor * this.taxa)));
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
        if (contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()) {
            taxa = (float) 0.01;
        } else {
            taxa = (float) 0.005;
        }
        setSaldo(getSaldo() - (valor * this.taxa));
        getTransacoes().add(new Transacao(TipoTransacao.TAXA,Data.getDataTransacao(), (valor * this.taxa)));
    }




}
