package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSeriesResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
    static ConsultarDetalhesSeriesResponseMapper MAPPER_DETALHES_SERIE = new ConsultarDetalhesSeriesResponseMapper();

    public List<SerieResponse> getSeries(){
        final List<SerieEntity> series = seriesRepository.getSeries();
        return MAPPER_RESPONSE.mapear(series);
    }

    public ConsultarDetalhesSerieResponse consultarDetalhesSeriePorId(Long id) {
        List<AtorEntity> atorSeries = atoresRepository.acharFilmeAtor(id);
        SerieEntity serieSalva = seriesRepository.acharSeriePorId(id);
        return MAPPER_DETALHES_SERIE.mapear(serieSalva, atorSeries);
    }
}
