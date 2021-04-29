package br.com.cwi.reset.tcc.response;


import br.com.cwi.reset.tcc.dominio.FormaPagamento;
import br.com.cwi.reset.tcc.dominio.HorarioFuncionamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EstabelecimentoResponse {

    private Long id;

    private String cnpj;

    private String nomeFantasia;

    private String razaoSocial;

    private List<HorarioFuncionamento> horariosFuncionamento;

    private List<FormaPagamento> formasPagamento;

    private List<EnderecoResponse> enderecos;

}
