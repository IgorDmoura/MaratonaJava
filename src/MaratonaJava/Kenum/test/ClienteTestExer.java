package MaratonaJava.Kenum.test;

import MaratonaJava.Kenum.classes.ClienteExer;
import MaratonaJava.Kenum.classes.TipoClienteExer;

public class ClienteTestExer {
    public static void main(String[] args) {
        ClienteExer clienteExer = new ClienteExer("Igor", TipoClienteExer.PESSOA_JURIDICA, ClienteExer.TipoPagamaento.APRAZO);
        System.out.println(clienteExer);
        System.out.println(TipoClienteExer.PESSOA_JURIDICA.getId());
        System.out.println(TipoClienteExer.PESSOA_FISICA.getId());
    }
}
