package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.response.EnderecoResponse;
import br.com.cwi.reset.tcc.response.EstabelecimentoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstabelecimentosPorIdResponseMapper {

    public EstabelecimentoResponse mapear(Estabelecimento estabelecimentoSalvo) {
        List<EnderecoResponse> enderecos = new ArrayList<>();

        for(Endereco endereco: estabelecimentoSalvo.getEnderecos()) {
            EnderecoResponse response = new EnderecoResponse(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getNumero(),
                    endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(),endereco.getEstado());
            enderecos.add(response);
        }


        return new EstabelecimentoResponse(estabelecimentoSalvo.getId(), estabelecimentoSalvo.getCnpj(), estabelecimentoSalvo.getNomeFantasia(),
                estabelecimentoSalvo.getRazaoSocial(), estabelecimentoSalvo.getHorariosFuncionamento(),estabelecimentoSalvo.getFormasPagamento(),enderecos);
    }
}
