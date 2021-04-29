package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSeriesResponseMapper;
import br.com.cwi.resetflix.mapper.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    SeriesResponseMapper seriesResponseMapper;

    @Autowired
    ConsultarDetalhesSeriesResponseMapper consultarDetalhesSeriesResponseMapper;

    @Autowired
    SerieEntityMapper serieEntityMapper;





    public List<SerieResponse> getSeries(Genero genero){
        List<SerieEntity> series = seriesRepository.getSeries();

        if(genero != null) {

            List<SerieEntity> list = new ArrayList<>();


            for (SerieEntity serie : series) {
                if (genero.equals(serie.getGenero())) {
                    list.add(serie);
                }
            }
            series = list;
        }

        return seriesResponseMapper.mapear(series);
    }

    public Long criarSerie(CriarSerieRequest request) {

        if(request.getNome() == null) {
            throw new BadRequestException("Dados inválidos para cadastro.");
        }

        SerieEntity serieSalvar = serieEntityMapper.mapear(request);
        return seriesRepository.criarSerie(serieSalvar);

    }

    public ConsultarDetalhesSerieResponse consultarDetalhesSeriePorId(Long id) {
        List<AtorEntity> atorSeries = atoresRepository.acharFilmeAtor(id);
        SerieEntity serieSalva = seriesRepository.acharSeriePorId(id);
        return consultarDetalhesSeriesResponseMapper.mapear(serieSalva, atorSeries);
    }
}
