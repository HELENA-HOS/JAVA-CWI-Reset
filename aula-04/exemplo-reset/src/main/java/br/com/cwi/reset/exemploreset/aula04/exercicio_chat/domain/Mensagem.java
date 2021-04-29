package br.com.cwi.reset.exemploreset.aula04.exercicio_chat.domain;

public class Mensagem {

    private String autor;
    private String mensagem;


    public Mensagem(String autor, String mensagem) {
        this.autor = autor;
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
