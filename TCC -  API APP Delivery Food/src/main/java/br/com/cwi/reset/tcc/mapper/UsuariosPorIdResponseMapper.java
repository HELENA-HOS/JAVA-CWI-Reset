package br.com.cwi.reset.tcc.mapper;


import br.com.cwi.reset.tcc.dominio.Usuario;
import br.com.cwi.reset.tcc.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuariosPorIdResponseMapper {


    public UsuarioResponse mapear(Usuario usuarioSalvo) {


        return new UsuarioResponse(usuarioSalvo.getId(), usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(),
                usuarioSalvo.getEnderecos());
    }
}
