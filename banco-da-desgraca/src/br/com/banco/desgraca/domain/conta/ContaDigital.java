package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.exception.BancoInvalidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

public class ContaDigital extends Conta{


    public ContaDigital(String numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validaBanco();
    }

    private static final Double saqueMinimo = 10d;

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getBanco();
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        if (valor < saqueMinimo) {
            throw new ValorInvalidoException("Valor inválido para essa operação.");
        }
    }

    private void validaBanco() {
        if(!this.getInstituicaoBancaria().getBanco().equals( InstituicaoBancaria.ITAU )|| !this.getInstituicaoBancaria().getBanco().equals(InstituicaoBancaria.NUBANK)){
            throw new BancoInvalidoException("Banco inválido para esse tipo de Conta Bancária");
        }
    }
}
