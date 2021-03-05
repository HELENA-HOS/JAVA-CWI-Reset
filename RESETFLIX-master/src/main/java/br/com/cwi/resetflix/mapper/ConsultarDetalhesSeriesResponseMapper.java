package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesSeriesResponseMapper {

    public ConsultarDetalhesSerieResponse mapear(final SerieEntity serieSalva, List<AtorEntity> atorFilmes) {
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atorFilmes);
        return new ConsultarDetalhesSerieResponse(atoresResponse, serieSalva.getId(),
            serieSalva.getNome(), serieSalva.getGenero(), serieSalva.getTemporada(), serieSalva.getEpisodio());
    }
}
