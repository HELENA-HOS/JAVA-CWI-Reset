
public class Casa extends Imovel {
    private boolean patio;

    public Casa(Endereco endereco, Double valor, String tipo, boolean patio) {
        super(endereco, valor, tipo);
        this.patio = patio;
    }



    @Override
    public String apresentacao() {
        return super.apresentacao() + "\n --> Esta casa " + (this.patio ? "possui":"não possui") + " pátio.\n";
    }
}
