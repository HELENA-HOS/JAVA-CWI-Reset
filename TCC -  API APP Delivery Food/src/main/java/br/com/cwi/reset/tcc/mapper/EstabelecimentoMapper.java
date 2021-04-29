package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.request.CriarEstabelecimentoRequest;
import org.springframework.stereotype.Component;

@Component
public class EstabelecimentoMapper {

    public Estabelecimento mapear(CriarEstabelecimentoRequest request) {
        return new Estabelecimento(request.getCnpj(), request.getNomeFantasia(), request.getRazaoSocial(),
                request.getHorariosFuncionamento(), request.getFormasPagamento(), request.getEnderecos());
    }
}
