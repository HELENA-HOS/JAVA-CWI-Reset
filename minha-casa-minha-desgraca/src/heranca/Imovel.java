package heranca;

import domain.Endereco;

public abstract class Imovel {
    private Endereco endereco;
    private Double valor;
    private String tipo;


    public Imovel(Endereco endereco, Double valor, String tipo) {
        this.endereco = endereco;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String apresentacao() {
        return this.tipo + ", localizado(a) em " + endereco.getLogradouro() + "," + endereco.getNumero() + " - " +
                endereco.getComplemento() + " - " + endereco.getBairro() + " - " + endereco.getCidade() + " - "
                + endereco.getEstado() + ". "
                + "\n" +" --> Valor: R$ "  + this.valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Double getValor() {
        return valor;
    }
}







