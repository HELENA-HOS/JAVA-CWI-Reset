package br.com.banco.desgraca;

import br.com.banco.desgraca.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaCorrente caixa1 = new ContaCorrente("451-7",InstituicaoBancaria.CAIXA);
//
//        ContaCorrente bradesco1 = new ContaCorrente("123-4", InstituicaoBancaria.BRADESCO);
//
//        bradesco1.depositar(200d);
//        bradesco1.sacar(150d);
//        bradesco1.depositar(1000d);
//        bradesco1.transferir(100d, caixa1);
//        bradesco1.sacar(120d);
//        bradesco1.exibirExtrato(null,null);


//        ContaCorrente caixa1 = new ContaCorrente("451-7",InstituicaoBancaria.CAIXA);
//
//
        ContaPoupanca itau1 = new ContaPoupanca("235-7", InstituicaoBancaria.ITAU);
        ContaPoupanca itau2 = new ContaPoupanca("056-3", InstituicaoBancaria.ITAU);

            itau1.depositar(200d);
            itau1.sacar(150d);
            itau1.depositar(1000d);
            itau1.transferir(100d, caixa1);
            itau1.transferir(100d, itau2);
            itau1.sacar(100d);
            itau1.exibirExtrato(null,null);


//        ContaPoupanca bb1 = new ContaPoupanca("819-4",InstituicaoBancaria.NUBANK);
//
//
//
//        ContaDigital nubank1 = new ContaDigital("658-3", InstituicaoBancaria.NUBANK);
////
//        nubank1.depositar(200d);
//        nubank1.sacar(150d);
//        nubank1.depositar(1000d);
//        nubank1.transferir(100d, caixa1);
//        nubank1.sacar(9d);
//        nubank1.exibirExtrato(null,null);

//        ContaDigital bradesco1 = new ContaDigital("222-8",InstituicaoBancaria.BRADESCO);










    }


}
