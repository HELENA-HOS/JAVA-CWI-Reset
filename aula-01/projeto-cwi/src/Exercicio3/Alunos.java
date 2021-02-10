package Exercicio3;

public class Alunos {
    String nome;
    Double nota;


    public Alunos(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }


    void resultadoFinal () {
        System.out.println("Aluno: " + nome);
        System.out.println("Nota final: " + nota);
        System.out.println("O aluno foi aprovado: " + (nota >=7.0));
    }
}