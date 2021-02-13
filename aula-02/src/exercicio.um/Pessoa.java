package exercicio.um;

public class Pessoa {
    private String nome;
    private int idade;
    private Genero genero;


    public Pessoa(String nome, int idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void imprimirInformacoes(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + this.genero.getDescricao());
        System.out.println("");
    }

    public String getNome() {
        return nome;
    }
}
