package br.com.cwi.reset.tcc.web;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.Estabelecimento;
import br.com.cwi.reset.tcc.request.CriarEstabelecimentoRequest;
import br.com.cwi.reset.tcc.response.EstabelecimentoResponse;
import br.com.cwi.reset.tcc.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estabelecimento criarEstabelecimento(@RequestBody @Valid CriarEstabelecimentoRequest request) {
        return estabelecimentoService.criarEstabelecimento(request);
    }

    @GetMapping
    public Page<Estabelecimento> listarEstabelecimentos(Pageable pageable){
        return estabelecimentoService.listarEstabelecimentos(pageable);
    }

    @GetMapping("/{id}")
    public EstabelecimentoResponse buscarEstabelecimentoPorId(@PathVariable("id") Long id){
        return estabelecimentoService.buscarEstabelecimentoPorId(id);
    }

    @DeleteMapping("/{id}/enderecos/{idEndereco}")
    public void deletarEnderecoEstabelecimento(@PathVariable("id") Long idEstabelecimento,@PathVariable("idEndereco") Long idEndereco) {
        estabelecimentoService.deletarEnderecoEstabelecimento(idEstabelecimento, idEndereco);

    }

    @PostMapping("/{id}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarEndereco(@PathVariable("id") Long idEstabelecimento,@RequestBody @Valid Endereco endereco) {
        estabelecimentoService.adicionarEndereco(idEstabelecimento,endereco);
    }

}
