package br.com.cwi.reset.exemploreset.aula04.exercicio4.service;


import br.com.cwi.reset.exemploreset.aula04.exercicio4.domain.Usuario;
import br.com.cwi.reset.exemploreset.aula04.exercicio4.exceptions.BadRequestException;
import br.com.cwi.reset.exemploreset.aula04.exercicio4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getUsuario() {
        return repository.getUsuarios();
    }


    public Usuario criarUsuario(Usuario usuario) {
        if ( usuario == null) {
            throw new BadRequestException();
        }

        if(usuario.getId() != null) {
            throw new BadRequestException();
        }
        return repository.addUsuario(usuario);
    }

    public void deletarUsuario(Long idDeletar) {
        repository.deletarUsuario(idDeletar);
    }
}
