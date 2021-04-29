package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.repository.UsuarioRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private FilmeResponseMapper filmeResponseMapper;

    @Autowired
    private FilmeEntityMapper filmeEntityMapper;

    @Autowired
    private ConsultarDetalhesFilmeResponseMapper consultarDetalhesFilmeResponseMapper;

    @Autowired
    UsuarioRepository usuarioRepository;



    public List<FilmeResponse> getFilmes(Genero genero) {
        List<FilmeEntity> filmes = filmeRepository.getFilmes();

        if(genero!= null) {

            List<FilmeEntity> list = new ArrayList<>();


            for (FilmeEntity filme : filmes) {
                if (genero.equals(filme.getGenero())) {
                    list.add(filme);
                }
            }
            filmes = list;

        }

        return filmeResponseMapper.mapear(filmes);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(Long id) {
        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(id);

        if (filmeSalvo == null) {
            throw new NotFoundException("Filme não localizado");
        }

        List<AtorEntity> atorFilmes = atoresRepository.acharFilmeAtor(id);
        DiretorEntity diretorFilmes = diretoresRepository.acharDiretorPorId(filmeSalvo.getIdDiretor());
        return consultarDetalhesFilmeResponseMapper.mapear(filmeSalvo, atorFilmes, diretorFilmes);

    }

    public Long criarFilme(CriarFilmeRequest request) {

        if(request.getNome() == null) {
            throw new BadRequestException("Dados inválidos para cadastro.");
        }

        FilmeEntity filmeSalvar = filmeEntityMapper.mapear(request);
        return filmeRepository.criarFilme(filmeSalvar);

    }

    public List<FilmeResponse> obterFilmesRecomendados(){

        List<Long> idsFilmesAssistidos = usuarioRepository.getIdsFilmesAssistidos();
        Genero generoMaisAssistido = obterGeneroMaisAssitido(idsFilmesAssistidos);
        List<FilmeEntity> filmesRecomendados = filmeRepository.acharFilmeGeneroAssistido(generoMaisAssistido, idsFilmesAssistidos);

        return filmeResponseMapper.mapear(filmesRecomendados);

    }

    private Genero obterGeneroMaisAssitido(List<Long> idsFilmesAssistidos) {

        Map<Genero, Integer> generoOcorrencias = new HashMap<>();

        List<FilmeEntity> filmes = filmeRepository.acharFilmesPorIds(idsFilmesAssistidos);

        filmes.stream().map(filme -> filme.getGenero()).forEach(genero -> {
            if (generoOcorrencias.containsKey(genero)) {
                generoOcorrencias.put(genero, generoOcorrencias.get(genero) + 1);
            } else {
                generoOcorrencias.put(genero, 0);
            }
        });

        int contagemMaxima = -1;
        Genero maisAssistido = null;

        for (final Entry<Genero, Integer> val : generoOcorrencias.entrySet()) {
            if (contagemMaxima < val.getValue()) {
                maisAssistido = val.getKey();
                contagemMaxima = val.getValue();
            }
        }

        return maisAssistido;

    }
}

