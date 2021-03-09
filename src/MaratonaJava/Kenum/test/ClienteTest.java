package MaratonaJava.Kenum.test;

import MaratonaJava.Kenum.classes.Cliente;
import MaratonaJava.Kenum.classes.TipoCliente;

public class ClienteTest {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Anna", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);
        System.out.println(cliente);

    }
}
