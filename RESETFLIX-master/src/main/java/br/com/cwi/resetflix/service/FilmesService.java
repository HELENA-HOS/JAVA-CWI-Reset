package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;


    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();

    public List<FilmeResponse> getFilmes() {
        final List<FilmeEntity> filmes = filmeRepository.getFilmes();
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(Long id) {
        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(id);
        List<AtorEntity> atorFilmes = atoresRepository.acharFilmeAtor(id);
        DiretorEntity diretorFilmes = diretoresRepository.acharDiretorPorId(id);
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, atorFilmes, diretorFilmes);

    }
}
