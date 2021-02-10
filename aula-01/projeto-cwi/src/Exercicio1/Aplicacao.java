package Exercicio1;

import Exercicio1.Calculadora;

public class Aplicacao {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora ();
        int resultadoSoma = calculadora.soma(1, 2);
        System.out.println("Resultado da soma é igual a " + resultadoSoma);

        int resultadoSubtrai = calculadora.subtrai(15,5);
        System.out.println("Resultado da subtração é " + resultadoSubtrai);

        int resultadoMultiplica = calculadora.multiplica(3,4);
        System.out.println("Resultado da multiplicação é " + resultadoMultiplica);

        int resultadoDivide = calculadora.divide(15,3);
        System.out.println("Resultado da divisão é " + resultadoDivide);

    }
}