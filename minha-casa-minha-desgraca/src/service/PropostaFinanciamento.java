package service;

import domain.Beneficiario;
import heranca.Imovel;

public class PropostaFinanciamento {
    private Beneficiario beneficiario;
    private Imovel imovelEscolhido;
    private int mesesParaPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovelEscolhido = imovelEscolhido;
        this.mesesParaPagamento = mesesParaPagamento;
    }


    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     * <p>
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     * for equivalente a pelo menos 50% do valor do imóvel.
     * <p>
     * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    public void validarProposta() {
        if (imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.SP) {
            if ((beneficiario.getSalario() * mesesParaPagamento) >= (imovelEscolhido.getValor() * 0.65)) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else if (imovelEscolhido.getEndereco().getEstado() == UnidadeFederativa.RJ) {
            if ((beneficiario.getSalario() * mesesParaPagamento) >= (imovelEscolhido.getValor() * 0.6)) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else if (imovelEscolhido.getEndereco().getEstado() != UnidadeFederativa.RJ && imovelEscolhido.getEndereco().getEstado()
                != UnidadeFederativa.SP) {
            if ((beneficiario.getSalario() * mesesParaPagamento) >= (imovelEscolhido.getValor() * 0.5)) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        } else {
            imprimirPropostaNegada();
        }

    }

    private void imprimirPropostaAprovada () {
        System.out.println("Parabéns," + beneficiario.getNome() + "!");
        System.out.println("Foi APROVADA a proposta de financiamento do imóvel escolhido:");
        System.out.println(imovelEscolhido.apresentacao() +" --> Pagamento em " + mesesParaPagamento +  " meses!");
        System.out.println("*** Bora arrumar essa mudança!!! ***");
    }
    private void imprimirPropostaNegada () {
        System.out.println("Afff...Sem chance né," + beneficiario.getNome() + "!");
        System.out.println("Claro que foi NEGADA a proposta de financiamento do imóvel escolhido: ");
        System.out.println(imovelEscolhido.apresentacao() +" --> Pagamento em " + mesesParaPagamento +  " meses!");
        System.out.println("*** Vai trabalhar mais, mané!! ***");
    }
}
