package exercicio.um;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int ano;
    private int nota;
    private Diretor diretor;


    public Filme(String nome, String descricao, int duracao, int ano, int nota, Diretor diretor) {
        defineNota(nota);
        validaNomeEDefineNota(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.nota = nota;
        this.diretor = diretor;
    }


    public void reproduzir() {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração do filme: " + this.duracao);
        System.out.println("Diretor: " + this.diretor.getNome());
        System.out.println("");
    }

    private void defineNota(int nota) {
        if (nota < 1 || nota > 5) {
            nota = 3;
        }
    }


    private void validaNomeEDefineNota(String nome) {
        if (nome == "O Clube da Luta") {
            nota = 5;
        } else if (nome == "Batman vs Superman") {
            nota = 1;
        } else {

        }
    }
}
