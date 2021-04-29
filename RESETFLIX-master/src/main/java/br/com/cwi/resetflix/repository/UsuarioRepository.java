package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    List<Long> idsFilmesAssistidos = new ArrayList<>();
    List<Long> idsSeriesAssistidas = new ArrayList<>();


    public void registrarFilmeAssistido(Long idFilme) {
        idsFilmesAssistidos.add(idFilme);
    }

    public void registrarSerieAssistida(Long idSerie){
        idsSeriesAssistidas.add(idSerie);
    }

    public List<Long> getIdsFilmesAssistidos() {
        return idsFilmesAssistidos;
    }

    public List<Long> getIdsSeriesAssistidas() {
        return idsSeriesAssistidas;
    }
}
