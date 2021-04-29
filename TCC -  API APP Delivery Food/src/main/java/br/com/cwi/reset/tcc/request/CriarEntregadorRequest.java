package br.com.cwi.reset.tcc.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CriarEntregadorRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotBlank
    @Valid
    private String placaVeiculo;
}
