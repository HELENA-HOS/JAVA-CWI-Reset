
public class Apartamento extends Imovel {
    private String andar;

    public Apartamento(Endereco endereco, Double valor, String tipo, String andar) {
        super(endereco, valor, tipo);
        this.andar = andar;
    }


    @Override
    public String apresentacao() {
        return super.apresentacao() + "\n --> Este apartamento fica no " + andar + " andar.\n";
    }
}
