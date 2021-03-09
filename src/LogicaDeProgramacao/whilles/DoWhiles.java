package LogicaDeProgramacao.whilles;

public class DoWhiles {
    public static void main(String[] args) {

        int contador = 0;
        do {
            System.out.println("Do While " + (contador + 1));
            contador++;
        } while(contador < 10);

    }
}
