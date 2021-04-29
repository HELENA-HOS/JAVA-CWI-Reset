package br.com.cwi.reset.tcc.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntregadorResponse {

    private Long id;

    private String cpf;

    private String nome;

    private String telefone;

    private String placaVeiculo;

    private Boolean disponivel;

}
