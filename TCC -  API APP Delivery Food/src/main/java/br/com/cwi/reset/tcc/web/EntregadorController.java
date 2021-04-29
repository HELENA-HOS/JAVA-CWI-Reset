package br.com.cwi.reset.tcc.web;

import br.com.cwi.reset.tcc.dominio.Entregador;
import br.com.cwi.reset.tcc.request.CriarEntregadorRequest;
import br.com.cwi.reset.tcc.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    EntregadorService entregadorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entregador criarEntregador(@RequestBody @Valid CriarEntregadorRequest request) {
        return entregadorService.criarEntregador(request);
    }

    @GetMapping
    public Page<Entregador> listarEntregadores(Pageable pageable){
        return entregadorService.listarEntregadores(pageable);
    }
}
