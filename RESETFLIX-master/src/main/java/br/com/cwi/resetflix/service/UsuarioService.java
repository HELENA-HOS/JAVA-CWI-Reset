package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    SeriesRepository seriesRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    public void assistirFilme( Long idFilme) {

        FilmeEntity filme = filmeRepository.acharFilmePorId(idFilme);

        if (filme == null) {
            throw new NotFoundException("Filme não cadastrado.");
        }

        usuarioRepository.registrarFilmeAssistido(idFilme);
    }

    public void assistirSerie( Long idSerie, Integer temporada, Integer episodio) {

        SerieEntity serie = seriesRepository.acharSeriePorId(idSerie);

        if (serie == null) {
            throw new NotFoundException("Série não cadastrada.");
        }

        if (temporada > serie.getTemporada() || episodio > serie.getEpisodio()) {
            throw new BadRequestException("Episódio ou Temporada não cadastrados.");
        }

        usuarioRepository.registrarSerieAssistida(idSerie);
    }


}
