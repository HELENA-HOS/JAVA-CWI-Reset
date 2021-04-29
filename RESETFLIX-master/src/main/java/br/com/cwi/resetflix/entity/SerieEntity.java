package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class SerieEntity {

    private Long id;
    private String nome;
    private Genero genero;
    private Integer temporada;
    private Integer episodio;
    private List<Long> idsAtores;

    public SerieEntity(Long id, String nome, Genero genero, Integer temporada, Integer episodio, List<Long> idsAtores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.temporada = temporada;
        this.episodio = episodio;
        this.idsAtores = idsAtores;
    }

    public SerieEntity(String nome, Genero genero, Integer temporada, Integer episodio, List<Long> idsAtores) {
        this.nome = nome;
        this.genero = genero;
        this.temporada = temporada;
        this.episodio = episodio;
        this.idsAtores = idsAtores;
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

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }
}
