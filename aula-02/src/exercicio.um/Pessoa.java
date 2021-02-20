package exercicio.um;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;


    public Pessoa(String nome, LocalDate dataDeNascimento, Genero genero) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
    }

    private int calcularIdade() {
            Period periodo = Period.between(dataDeNascimento,LocalDate.now());
            return periodo.getYears();
    }

    public void imprimirInformacoes(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: " + calcularIdade());
        System.out.println("Genero: " + this.genero.getDescricao());
        System.out.println("");
    }

    public String getNome() {
        return nome;
    }


}
