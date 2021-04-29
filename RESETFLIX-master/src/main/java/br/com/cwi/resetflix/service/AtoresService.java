package br.com.cwi.resetflix.service;

import java.util.List;

import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.response.AtoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class AtoresService {

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresResponseMapper atoresResponseMapper;

    @Autowired
    private AtorEntityMapper atorEntityMapper;

    @Autowired
    private ConsultarDetalhesAtorResponseMapper consultarDetalhesAtorResponseMapper;


    public List<AtoresResponse> getAtores() {
        final List<AtorEntity> atores = atoresRepository.getAtores();
        return atoresResponseMapper.mapear(atores);
    }

    public Long criarAtor(final CriarAtorRequest request) {
        if (request == null) {
            throw new BadRequestException("Dados inválidos para cadastro de ator.");
        }

        AtorEntity atorSalvar = atorEntityMapper.mapear(request);
        return atoresRepository.criarAtor(atorSalvar);
    }



    public ConsultarDetalhesAtorResponse consultarDetalhesAtor(final Long id) {
        AtorEntity atorSalvo = atoresRepository.acharAtorPorId(id);

        if(atorSalvo == null) {
            throw new NotFoundException("Ator não cadastrado.");
        }

        List<FilmeEntity> filmesAtor = filmeRepository.acharFilmesAtor(id);
        return consultarDetalhesAtorResponseMapper.mapear(atorSalvo, filmesAtor);
    }
}
