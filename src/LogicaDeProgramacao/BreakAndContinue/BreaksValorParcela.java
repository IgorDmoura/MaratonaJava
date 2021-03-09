package LogicaDeProgramacao.BreakAndContinue;

public class BreaksValorParcela {
    public static void main(String[] args) {
        //Dado um Valor de um Carro descubra em quantas vezes ele pode ser parcelado
        //Porém as parcelas não podem ser menores que 1000

        double valortotal = 30000;
        for (int parcela = 1; parcela < valortotal; parcela++) {
            double valorparcela = valortotal / parcela;
            if (valorparcela < 1000) {
                break;
            } else {
                System.out.println("Parcela " + parcela + " R$ " + valorparcela);
            }

        }
        System.out.println("Programa Encerrado");
    }
}

