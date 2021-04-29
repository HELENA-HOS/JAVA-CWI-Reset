package com.company.domain;

import com.company.exceptions.DcLongeDaqui;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        validaNome(nome);
        this.nome = nome;
        this.localizacao = localizacao;

    }

    private void validaNome(String nome) {
        if (nome.equals("DC Comics")) {
            throw new DcLongeDaqui("Sai fora!! Dc Comics aqui não!");
        }
    }

    public String getNome() {
        return nome;
    }
}
