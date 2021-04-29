package br.com.cwi.reset.tcc.response;
import br.com.cwi.reset.tcc.dominio.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;

    private String cpf;

    private String nome;

    private String email;

    private List<Endereco> enderecos;

}
