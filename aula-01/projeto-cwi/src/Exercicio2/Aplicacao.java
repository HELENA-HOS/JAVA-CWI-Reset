package Exercicio2;

public class Aplicacao {

    public static void main(String[] args) {

        Comparador comparador = new Comparador();
        boolean resultado = comparador.menorQue(5,9);
        System.out.println("Primeiro número é menor do que o segundo? " + resultado);
    }
}
