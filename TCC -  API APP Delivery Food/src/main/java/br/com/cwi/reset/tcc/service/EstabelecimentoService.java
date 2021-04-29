package br.com.cwi.reset.tcc.service;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.exceptions.*;
import br.com.cwi.reset.tcc.mapper.EstabelecimentoMapper;
import br.com.cwi.reset.tcc.mapper.EstabelecimentosPorIdResponseMapper;
import br.com.cwi.reset.tcc.repository.EnderecoRepository;
import br.com.cwi.reset.tcc.repository.EstabelecimentoRepository;
import br.com.cwi.reset.tcc.request.CriarEstabelecimentoRequest;
import br.com.cwi.reset.tcc.response.EstabelecimentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoService {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    EstabelecimentoMapper estabelecimentoMapper;

    @Autowired
    EstabelecimentosPorIdResponseMapper estabelecimentosPorIdResponseMapper;

    @Autowired
    EnderecoRepository enderecoRepository;


    // ------ ***** METÓDO CADASTRO ESTABELECIMENTO ***** ------ //

    public Estabelecimento criarEstabelecimento(CriarEstabelecimentoRequest request) {

        if(estabelecimentoRepository.existsByCnpj(request.getCnpj())){
            throw new CnpjJaCadastradoException();
        }

        Estabelecimento estabelecimentoSalvar = estabelecimentoMapper.mapear(request);
        estabelecimentoRepository.save(estabelecimentoSalvar);
        return estabelecimentoSalvar;
    }


    // ------ ***** METÓDO LISTAGEM ESTABELECIMENTO ***** ------ //

    public Page<Estabelecimento> listarEstabelecimentos(Pageable pageable) {
        return estabelecimentoRepository.findAllByOrderByNomeFantasiaAsc(pageable);
    }


    // ------ ***** METÓDO BUSCAR ESTABELECIMENTO POR ID ***** ------ //

    public EstabelecimentoResponse buscarEstabelecimentoPorId(Long id) {
        Estabelecimento estabelecimentoSalvo = estabelecimentoRepository.findById(id).orElse(null);

        if (estabelecimentoSalvo == null) {
            throw new EstabelecimentoNaoLocalizadoException();
        }

        return estabelecimentosPorIdResponseMapper.mapear(estabelecimentoSalvo);
    }


    // ------ ***** METÓDO REMOVER ENDEREÇO DO ESTABELECIMENTO ***** ------ //

    public void deletarEnderecoEstabelecimento(Long idEstabelecimento, Long idEndereco) {
            Estabelecimento estabelecimentoEndereco = estabelecimentoRepository.findById(idEstabelecimento).orElseThrow(()
                    -> new EstabelecimentoNaoLocalizadoException());
            Endereco endereco = enderecoRepository.findById(idEndereco).orElseThrow(()
                    -> new EnderecoNaoLocalizadoException());

        if (!estabelecimentoEndereco.getEnderecos().contains(endereco)) {
            throw new EstabelecimentoEnderecoInvalidoException();
        }
            estabelecimentoEndereco.getEnderecos().remove(endereco);
            enderecoRepository.delete(endereco);
        }


    // ------ ***** METÓDO ADICIONAR ENDEREÇO DO ESTABELECIMENTO ***** ------ //

    public void adicionarEndereco(Long idEstabelecimento, Endereco endereco) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(idEstabelecimento).orElseThrow(()
                -> new EstabelecimentoNaoLocalizadoException());
        estabelecimento.getEnderecos().add(endereco);
        estabelecimentoRepository.save(estabelecimento);
    }


}
