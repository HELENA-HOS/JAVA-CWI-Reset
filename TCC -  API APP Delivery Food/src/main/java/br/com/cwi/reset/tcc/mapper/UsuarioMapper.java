package br.com.cwi.reset.tcc.mapper;

import br.com.cwi.reset.tcc.dominio.Usuario;
import br.com.cwi.reset.tcc.request.UsuarioRequest;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario mapear(UsuarioRequest request) {
        return new Usuario(request.getCpf(), request.getNome(), request.getEmail(), request.getSenha(), request.getEnderecos());
    }
}
