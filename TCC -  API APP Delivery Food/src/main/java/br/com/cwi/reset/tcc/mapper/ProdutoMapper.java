package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.dominio.Produto;
import br.com.cwi.reset.tcc.request.CriarProdutoRequest;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto mapear(CriarProdutoRequest request, Estabelecimento estabelecimento) {
        return new Produto(request.getTitulo(), request.getDescricao(), request.getValor(), request.getUrlFoto(),
                request.getCategoria(), request.getTempoPreparo(), estabelecimento);

    }
}
