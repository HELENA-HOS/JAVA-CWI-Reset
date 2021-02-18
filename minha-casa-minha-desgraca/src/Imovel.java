
public class Imovel {
    private Endereco endereco;
    private Double valor;

    public Imovel(Endereco endereco, Double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }


    public String apresentacao() {
        return "Imóvel localizado no endereço " + endereco.getLogradouro() + "," +endereco.getNumero() +" - "+
                endereco.getComplemento()+" - "+ endereco.getBairro()+" - "+endereco.getCidade()+" - " + endereco.getEstado() + ". " + "Valor: R$ " + this.valor;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public Double getValor() {
        return valor;
    }
}

