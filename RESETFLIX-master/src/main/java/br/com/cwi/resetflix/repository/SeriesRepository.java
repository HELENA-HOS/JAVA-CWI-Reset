package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class SeriesRepository {

    static List<SerieEntity> series= new ArrayList<>();
    static Long contadorIds = 1l;


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


    public Long criarSerie(SerieEntity serieSalvar) {

        if(serieSalvar.getId() == null){
            serieSalvar.setId(contadorIds);
            contadorIds++;
        }

        series.add(serieSalvar);

        return serieSalvar.getId();

    }
}
