package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
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

    @Autowired
    DiretoresResponseMapper diretoresResponseMapper;

    @Autowired
    ConsultarDetalhesDiretorResponseMapper consultarDetalhesDiretorResponseMapper;

    @Autowired
    DiretorEntityMapper diretorEntityMapper;

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.getDiretores();
        return diretoresResponseMapper.mapeard(diretores);
    }

    public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(final Long id) {
        DiretorEntity diretorSalvo = diretoresRepository.acharDiretorPorId(id);
        List<FilmeEntity> filmesDiretor = filmeRepository.acharFilmesDiretor(id);
        return consultarDetalhesDiretorResponseMapper.mapear(diretorSalvo, filmesDiretor);
    }


    public Long criarDiretor(CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = diretorEntityMapper.mapear(request);
        return diretoresRepository.criarDiretor(diretorSalvar);
    }
}
