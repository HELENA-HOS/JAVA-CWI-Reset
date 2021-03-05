package br.com.cwi.resetflix.response;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class ConsultarDetalhesSerieResponse {

    private Long id;
    private String nome;
    private Genero genero;
    private Integer temporada;
    private Integer episodio;
    private List<AtoresResponse> atores;

    public ConsultarDetalhesSerieResponse(List<AtoresResponse> atores, Long id, String nome, Genero genero, Integer temporada, Integer episodio) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.temporada = temporada;
        this.episodio = episodio;
        this.atores = atores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public Integer getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Integer episodio) {
        this.episodio = episodio;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public void setAtores(List<AtoresResponse> atores) {
        this.atores = atores;
    }
}
