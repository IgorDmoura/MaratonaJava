package MaratonaJava.Minterfaces.test;

import MaratonaJava.Minterfaces.classes.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        Produto p  = new Produto("Notebook",4,3000);
        p.calculaImposto();
        p.calculaFrete();
        System.out.println(p);
    }
}
