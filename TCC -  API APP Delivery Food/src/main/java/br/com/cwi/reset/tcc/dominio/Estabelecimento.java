package br.com.cwi.reset.tcc.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String nomeFantasia;

    private String razaoSocial;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estabelecimento")
    private List<HorarioFuncionamento> horariosFuncionamento;

    @ElementCollection(targetClass = FormaPagamento.class)
    @JoinTable(name = "FORMAS_PAGAMENTO", joinColumns = @JoinColumn(name = "cnpj"))
    @Enumerated(EnumType.STRING)
    private List<FormaPagamento> formasPagamento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estabelecimento")
    private List<Endereco> enderecos;




    public Estabelecimento(String cnpj, String nomeFantasia, String razaoSocial, List<HorarioFuncionamento> horariosFuncionamento,
                           List<FormaPagamento> formasPagamento, List<Endereco> enderecos) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.horariosFuncionamento = horariosFuncionamento;
        this.formasPagamento = formasPagamento;
        this.enderecos = enderecos;
    }

    public Estabelecimento() {
    }
}
