package br.com.cwi.reset.exemploreset.aula04.exercicio4;


import br.com.cwi.reset.exemploreset.aula04.exercicio4.domain.Usuario;
import br.com.cwi.reset.exemploreset.aula04.exercicio4.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuario();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable("id") Long idDeletar) {
        usuarioService.deletarUsuario(idDeletar);

    }
}