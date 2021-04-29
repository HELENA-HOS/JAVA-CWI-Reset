package br.com.cwi.reset.tcc.request;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.FormaPagamento;
import br.com.cwi.reset.tcc.dominio.HorarioFuncionamento;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class CriarEstabelecimentoRequest {

    @NotBlank
    private String cnpj;

    @NotBlank
    private String nomeFantasia;

    @NotBlank
    private String razaoSocial;

    @NotEmpty
    private List<HorarioFuncionamento> horariosFuncionamento;

    @NotEmpty
    private List<FormaPagamento> formasPagamento;

    private List<Endereco> enderecos;
}
