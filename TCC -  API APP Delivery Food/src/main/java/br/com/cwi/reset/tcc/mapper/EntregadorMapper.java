package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Entregador;
import br.com.cwi.reset.tcc.request.CriarEntregadorRequest;
import org.springframework.stereotype.Component;

@Component
public class EntregadorMapper {

    public Entregador mapear(CriarEntregadorRequest request) {
        return new Entregador(request.getCpf(), request.getNome(), request.getTelefone(), request.getPlacaVeiculo());
    }

}
