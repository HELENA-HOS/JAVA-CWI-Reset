package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.*;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filmeSalvo, List<AtorEntity> atorFilmes, DiretorEntity diretorFilmes) {
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atorFilmes);
        DiretoresResponse diretoresResponse = new DiretoresResponseMapper().mapear(diretorFilmes);
        return new ConsultarDetalhesFilmeResponse(filmeSalvo.getId(),
            filmeSalvo.getNome(), filmeSalvo.getGenero(), diretoresResponse, atoresResponse);
    }
}
