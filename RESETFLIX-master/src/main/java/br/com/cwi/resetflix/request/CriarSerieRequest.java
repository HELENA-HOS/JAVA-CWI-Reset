package br.com.cwi.resetflix.request;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class CriarSerieRequest {

    private String nome;
    private List<Long> idsAtores;
    private Integer temporada;
    private Integer episodio;
    private Genero genero;

    public CriarSerieRequest(String nome, List<Long> idsAtores, Integer temporadas, Integer episodios, Genero genero) {
        this.nome = nome;
        this.idsAtores = idsAtores;
        this.temporada = temporadas;
        this.episodio = episodios;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }

    public Integer getTemporadas() {
        return temporada;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporada = temporadas;
    }

    public Integer getEpisodios() {
        return episodio;
    }

    public void setEpisodios(Integer episodios) {
        this.episodio = episodios;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
