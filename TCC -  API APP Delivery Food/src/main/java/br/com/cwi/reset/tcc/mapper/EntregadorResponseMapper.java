package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Entregador;
import br.com.cwi.reset.tcc.response.EntregadorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntregadorResponseMapper {

    public List<EntregadorResponse> mapear(List<Entregador> entregadores) {
        List<EntregadorResponse> entregadorResponses = new ArrayList<>();

        for(Entregador entregador : entregadores) {
            EntregadorResponse entregadorResponse = new EntregadorResponse(entregador.getId(), entregador.getCpf(), entregador.getNome(),
                    entregador.getTelefone(), entregador.getPlacaVeiculo(),entregador.getDisponivel());

            entregadorResponses.add(entregadorResponse);
        }
        return entregadorResponses;
    }

}
