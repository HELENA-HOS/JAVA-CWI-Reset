package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class SeriesRepository {

    static List<SerieEntity> series = Collections.singletonList(
            new SerieEntity(1l,"La Casa de Papel", Genero.LENDARIO,
                    1,8, asList(1l))
    );


    public List<SerieEntity> getSeries() {
        return series;
    }

    public SerieEntity acharSeriePorId(Long id) {
        for(SerieEntity serieEntity : series){
            if(serieEntity.getId().equals(id)){
                return serieEntity;
            }
        }

        return null;
    }
}
