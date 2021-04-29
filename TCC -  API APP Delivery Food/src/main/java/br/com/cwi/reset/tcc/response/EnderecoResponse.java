package br.com.cwi.reset.tcc.response;

import br.com.cwi.reset.tcc.dominio.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoResponse {

    private Long id;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private Estado estado;

}
