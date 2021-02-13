package exercicio.um;

public class Diretor extends Pessoa{
    private int quantidadeFilmes;


    public Diretor(String nome, int idade, int quantidadeFilmes, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmes = quantidadeFilmes;

    }



}