package exercicio.um;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private int quantidadeFilmes;


    public Diretor(String nome, LocalDate dataDeNascimento, int quantidadeFilmes, Genero genero) {
        super(nome, dataDeNascimento, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

    @Override
    public void imprimirInformacoes() {
        super.imprimirInformacoes();
        System.out.println("Quantidade de filmes dirigidos: "+ this.quantidadeFilmes);
    }


}