package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretoresService {


    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();
    static ConsultarDetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.getDiretores();
        return MAPPER_RESPONSE.mapeard(diretores);
    }

    public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(final Long id) {
        DiretorEntity diretorSalvo = diretoresRepository.acharDiretorPorId(id);
        List<FilmeEntity> filmesDiretor = filmeRepository.acharFilmesDiretor(id);
        return MAPPER_DETALHES_DIRETOR.mapear(diretorSalvo, filmesDiretor);
    }


    public Long criarDiretor(CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretoresRepository.criarDiretor(diretorSalvar);
    }
}
