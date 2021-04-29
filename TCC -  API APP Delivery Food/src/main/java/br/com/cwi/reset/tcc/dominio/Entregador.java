package br.com.cwi.reset.tcc.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Entregador {

    public static final String REGEX_PLACA = "[A-Z]{3}"+" "+"[0-9][0-9A-Z][0-9]{2}";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    private String telefone;

    @Pattern(regexp = REGEX_PLACA, message = "A placa deve ser no formato AAA 9999 ou AAA 9A99.")
    private String placaVeiculo;

    private Boolean disponivel = true;



    public Entregador(String cpf, String nome, String telefone, String placaVeiculo) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.placaVeiculo = placaVeiculo;
    }

    public Entregador() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
