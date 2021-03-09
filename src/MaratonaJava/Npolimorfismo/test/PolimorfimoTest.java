package MaratonaJava.Npolimorfismo.test;

import MaratonaJava.Npolimorfismo.classes.*;

public class PolimorfimoTest {
    public static void main(String[] args) {
        Gerente g = new Gerente("Osvaldo",5000,2000);
        Vendedor v = new Vendedor("Yuri",2000,20000);
        RelatórioPagamento relatório = new RelatórioPagamento();
//        relatório.relatorioPagamentoGerente(g);
//        System.out.println("--------------------------------------------------------");
//        relatório.relatorioPagamentoVendedor(v);
        relatório.relatorioPagamentoGenerico(g);
        System.out.println("--------------------------------------------------------");
        relatório.relatorioPagamentoGenerico(v);
    }
}
