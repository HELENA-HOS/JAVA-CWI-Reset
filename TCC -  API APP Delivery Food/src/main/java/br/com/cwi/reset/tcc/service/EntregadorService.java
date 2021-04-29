package br.com.cwi.reset.tcc.service;

import br.com.cwi.reset.tcc.dominio.Entregador;
import br.com.cwi.reset.tcc.exceptions.CpfJaCadastradoException;
import br.com.cwi.reset.tcc.mapper.EntregadorMapper;
import br.com.cwi.reset.tcc.repository.EntregadorRepository;
import br.com.cwi.reset.tcc.request.CriarEntregadorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EntregadorService {

    @Autowired
    EntregadorRepository entregadorRepository;

    @Autowired
    EntregadorMapper entregadorMapper;


    // ------ ***** METÓDO CADASTRO ENTREGADOR ***** ------ //

    public Entregador criarEntregador(CriarEntregadorRequest request) {
        validarEntregador(request);

        Entregador salvarEntregador = entregadorMapper.mapear(request);
        entregadorRepository.save(salvarEntregador);
        return salvarEntregador;
    }

    // ------ ***** METÓDO AUXILIAR - CADASTRO ENTREGADOR ***** ------ //

    private void validarEntregador(CriarEntregadorRequest request) {
        if(entregadorRepository.existsByCpf(request.getCpf())){
            throw new CpfJaCadastradoException("CPF já cadastrado para outro entregador.");
        }
    }

    // ------ ***** METÓDO LISTAGEM ENTREGADOR ***** ------ //

    public Page<Entregador> listarEntregadores(Pageable pageable) {
        return entregadorRepository.findAllByOrderByNomeAsc(pageable);
    }
}
