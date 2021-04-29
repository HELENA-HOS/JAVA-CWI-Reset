package br.com.cwi.reset.tcc.web;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.Usuario;
import br.com.cwi.reset.tcc.request.UsuarioRequest;
import br.com.cwi.reset.tcc.response.UsuarioResponse;
import br.com.cwi.reset.tcc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody @Valid UsuarioRequest request) {
        return usuarioService.criarUsuario(request);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(Pageable pageable){
        return usuarioService.listarUsuarios(pageable);
    }



    @GetMapping("/{id}")
    public UsuarioResponse buscarUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario alterarUsuario(@PathVariable("id") Long idUsuario,@RequestBody UsuarioRequest request) {
        return usuarioService.alterarUsuario(idUsuario,request);
    }

    @DeleteMapping("/{id}/enderecos/{idEndereco}")
    public void deletarEnderecoUsuario(@PathVariable("id") Long idUsuario,@PathVariable("idEndereco") Long idEndereco) {
        usuarioService.deletarEnderecoUsuario(idUsuario, idEndereco);

    }

    @PostMapping("/{id}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarEndereco(@PathVariable("id") Long idUsuario,@RequestBody @Valid Endereco endereco) {
        usuarioService.adicionarEndereco(idUsuario,endereco);
    }


}
