package exercicio.um;

import java.time.LocalDate;

public class Ator extends Pessoa{
    private int numeroOscars;

    public Ator(String nome, LocalDate dataDeNascimento, Genero genero, int numeroOscars) {
        super(nome, dataDeNascimento, genero);
        this.numeroOscars = numeroOscars;
    }


    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Número de Oscars: "+ this.numeroOscars);
    }


}
