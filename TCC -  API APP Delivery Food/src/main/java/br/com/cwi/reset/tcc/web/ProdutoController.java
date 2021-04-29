package br.com.cwi.reset.tcc.web;

import br.com.cwi.reset.tcc.dominio.Produto;
import br.com.cwi.reset.tcc.request.CriarProdutoRequest;
import br.com.cwi.reset.tcc.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody @Valid CriarProdutoRequest request) {
        return produtoService.criarProduto(request);
    }

    @GetMapping
    public Page<Produto> listarProdutos(Pageable pageable) {
        return produtoService.listarProdutos(pageable);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") Long idDeletar) {
        produtoService.deletarProduto(idDeletar);

    }



}

