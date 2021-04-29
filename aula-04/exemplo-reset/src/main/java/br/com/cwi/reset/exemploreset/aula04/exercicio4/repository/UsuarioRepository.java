package br.com.cwi.reset.exemploreset.aula04.exercicio4.repository;


import br.com.cwi.reset.exemploreset.aula04.exercicio4.domain.Usuario;
import br.com.cwi.reset.exemploreset.aula04.exercicio4.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UsuarioRepository {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Long nextId = 1l;


    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario addUsuario( Usuario usuario) {
        usuario.setId(nextId);
        nextId++;
        usuarios.add(usuario);
        return usuario;
    }


    public void deletarUsuario(final Long idDeletar) {
        Usuario deletar = null;

        for(Usuario usuario : usuarios) {
            if(usuario.getId().equals(idDeletar)) {
                deletar = usuario
;            }
        }

        if(deletar == null) {
            throw new NotFoundException();
        }


        usuarios.remove(deletar);
    }


}
