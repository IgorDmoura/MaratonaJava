package LogicaDeProgramacao.BreakAndContinue;

public class BreaksValorParcelaInverso {
    public static void main(String[] args) {
        //Dado um Valor de um Carro descubra em quantas vezes ele pode ser parcelado
        //Porém as parcelas não podem ser menores que 1000

        double valortotal = 30000;
        for (int parcela = (int) valortotal ; parcela >= 1 ; parcela--) {
            double valorparcela = valortotal / parcela;
            if(valorparcela <= 1000) {
                continue;
            }
            System.out.println("Parcela " + parcela + " R$ " + valorparcela);
        }
    }
}

