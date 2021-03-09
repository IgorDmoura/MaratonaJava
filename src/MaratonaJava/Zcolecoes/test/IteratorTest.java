package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0, 5);
        Produto produto4 = new Produto("123", "Samsung Galxy S7 64GB", 3250.5, 0);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        Iterator<Produto> produtoIterator = produtos.iterator();

        //HasNext() - Verifica se existe um próximo elemento na lista
        //Next() - Pega o elemento daquela lista

        while (produtoIterator.hasNext()) { //Enquanto tiver um próximo produto
            if (produtoIterator.next().getQuantidade() == 0) { //Se a quantidade do próximo apontado for 0
                produtoIterator.remove(); //Remova o produto que foi apontado
            }
        }
        System.out.println(produtos.size());
    }
}
