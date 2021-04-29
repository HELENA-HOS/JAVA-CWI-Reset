package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeriesResponseMapper {

    public List<SerieResponse> mapear(final List<SerieEntity> seriesAtor) {
        List<SerieResponse> responses = new ArrayList<>();

        for(SerieEntity serieEntity : seriesAtor){
            responses.add(new SerieResponse(serieEntity.getId(),
                serieEntity.getNome(), serieEntity.getGenero()));
        }

        return responses;
    }
}
