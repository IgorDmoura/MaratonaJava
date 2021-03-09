package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Produto;

import java.util.*;

public class SetTeste {
    public static void main(String[] args) {
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0, 5);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        Produto produto5 = new Produto("999", "Samsung Galaxy S6 64GB", 3250.5, 0);
        Set<Produto> produtoSet = new LinkedHashSet<>(); //Set nao permite produtos repetidos
        //Se colocar new Hash set - O ultimo adicionado não fica na ultima posição - Sem indice
        //Se colocar new LinkedHashset - Ele segue a ordem de inserção - Possui indice
        //Nesse Exemplo nao permiti IMEI repetido
        produtoSet.add(produto1);
        produtoSet.add(produto2);
        produtoSet.add(produto3);
        produtoSet.add(produto4);
        produtoSet.add(produto5);
        for(Produto p : produtoSet){
            System.out.println(p);
        }
    }
}
