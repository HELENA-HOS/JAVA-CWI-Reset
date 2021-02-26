package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.exception.BancoInvalidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

public class ContaDigital extends Conta{


    public ContaDigital(String numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validaBanco();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getBanco();
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
        if (valor < 10d) {
            throw new ValorInvalidoException("Valor inválido para essa operação.");
        }
    }

    private void validaBanco() {
        if(this.getInstituicaoBancaria() != InstituicaoBancaria.ITAU && this.getInstituicaoBancaria() != InstituicaoBancaria.NUBANK){
            throw new BancoInvalidoException("Banco inválido para esse tipo de Conta Bancária");
        }
    }
}
