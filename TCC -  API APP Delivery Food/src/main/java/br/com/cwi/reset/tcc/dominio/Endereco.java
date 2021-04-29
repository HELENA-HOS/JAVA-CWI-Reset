package br.com.cwi.reset.tcc.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Endereco {

    public static final String REGEX_CEP = "[0-9]{5}-[0-9]{3}";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Pattern(regexp = REGEX_CEP, message = "O CEP deve ser no formato 99999-999")
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotNull
    private Estado estado;



}
