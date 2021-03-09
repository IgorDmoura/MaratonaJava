package MaratonaJava.Eblocodeinicializacao.test;

import MaratonaJava.Eblocodeinicializacao.classes.Cliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        System.out.println("Exibindo quantidade de parcelas possíveis");
        for(int parcela : c.getParcelas()) {
            System.out.print(parcela + " ");
        }
    }
}
