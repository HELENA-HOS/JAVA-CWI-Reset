package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import org.springframework.stereotype.Component;

@Component
public class AtoresResponseMapper {

    public List<AtoresResponse> mapear(final List<AtorEntity> atores) {
        List<AtoresResponse> atoresResponses = new ArrayList<>();

        for(AtorEntity atorEntity : atores){

            AtoresResponse atoresResponse = new AtoresResponse(atorEntity.getId(),
                atorEntity.getNome());

            atoresResponses.add(atoresResponse);
        }

        return atoresResponses;
    }
}
