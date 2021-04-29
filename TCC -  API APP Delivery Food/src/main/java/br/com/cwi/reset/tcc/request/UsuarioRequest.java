package br.com.cwi.reset.tcc.request;


import br.com.cwi.reset.tcc.dominio.Endereco;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @Valid
    private List<Endereco> enderecos;

}
