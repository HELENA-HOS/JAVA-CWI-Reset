package br.com.cwi.reset.tcc.service;

import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.dominio.Produto;
import br.com.cwi.reset.tcc.exceptions.EstabelecimentoNaoLocalizadoException;
import br.com.cwi.reset.tcc.exceptions.ProdutoNaoLocalizadoException;
import br.com.cwi.reset.tcc.exceptions.ValorProdutoInvalidoException;
import br.com.cwi.reset.tcc.mapper.ProdutoMapper;
import br.com.cwi.reset.tcc.repository.EstabelecimentoRepository;
import br.com.cwi.reset.tcc.repository.ProdutoRepository;
import br.com.cwi.reset.tcc.request.CriarProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;



    // ------ ***** METÓDO CADASTRAR PRODUTO ***** ------ //

    public Produto criarProduto(CriarProdutoRequest request) {
        validarProduto(request);

        Estabelecimento estabelecimento = estabelecimentoRepository.findAllById(request.getIdEstabelecimento());

        if(estabelecimento == null) {
            throw new EstabelecimentoNaoLocalizadoException();
        }

        Produto produtoSalvar = produtoMapper.mapear(request, estabelecimento);
        produtoRepository.save(produtoSalvar);
        return produtoSalvar;
    }

    // ------ ***** METÓDO AUXILIAR - CADASTRAR PRODUTO ***** ------ //

    public void validarProduto (CriarProdutoRequest request) {
        BigDecimal zero = BigDecimal.valueOf(0);

        if(request.getValor().compareTo(zero) == -1) {
            throw new ValorProdutoInvalidoException();
        }

        if(request.getTempoPreparo() == null) {
            request.setTempoPreparo(30);
        }
    }

    // ------ ***** METÓDO LISTAGEM PRODUTO ***** ------ //

    public Page<Produto> listarProdutos(Pageable pageable) {
        return produtoRepository.findAllByOrderByDescricaoAsc(pageable);
    }

    // ------ ***** METÓDO EXCLUSÃO PRODUTO ***** ------ //

    public void deletarProduto(Long idDeletar) {
        Produto produtoSalvo = produtoRepository.findById(idDeletar).orElse(null);

        if (produtoSalvo == null) {
            throw new ProdutoNaoLocalizadoException();
        }

        produtoRepository.deleteById(idDeletar);
    }
}
