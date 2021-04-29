package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import org.springframework.stereotype.Component;

@Component
public class DiretorEntityMapper {

    public DiretorEntity mapear(final CriarDiretorRequest request) {
        return new DiretorEntity(request.getNome(), request.getIdFilmes());
    }
}
