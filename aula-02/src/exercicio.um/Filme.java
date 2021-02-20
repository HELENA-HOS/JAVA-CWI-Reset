package exercicio.um;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int ano;
    private int nota;
    private Diretor diretor;
    private List<Pessoa> elenco;


    public Filme(String nome, String descricao, int duracao, int ano, int nota, Diretor diretor, List<Pessoa> elenco) {
        defineNota(nota);
        validaNomeEDefineNota(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.nota = nota;
        this.diretor = diretor;
        this.elenco = elenco;
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

    public void exibirCreditos () {
        System.out.println(" ***** " + this.nome + " ***** ");
        System.out.println("Elenco: ");
        for (Pessoa pessoa : elenco) {
            pessoa.imprimirInformacoes();
        }
    }

    public static void main(String[] args) {


        List<Pessoa> elenco = new ArrayList<Pessoa>();

        Diretor diretor = new Diretor("Carlos",LocalDate.of(1987,05,10),3,Genero.MASCULINO);

        elenco.add(diretor);
        elenco.add(new Ator("Paula",LocalDate.of(1970,03,25),Genero.FEMININO,3));
        elenco.add(new Ator("Juan",LocalDate.of(1973,06,18),Genero.MASCULINO,0));
        elenco.add(new Ator("Samara",LocalDate.of(1983,06,05),Genero.FEMININO,1));


        Filme batman = new Filme("Batman","Ação", 120, 2013, 4,diretor, elenco);

        batman.exibirCreditos();

    }
}


