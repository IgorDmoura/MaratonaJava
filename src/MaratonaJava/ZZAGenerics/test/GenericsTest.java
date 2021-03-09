package MaratonaJava.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        //Type erasure - Verificar em tempo de compilação o tipo
        //Tudo é object mas ele substitui o tipo pelo que foi marcado no generic
        //Mas em tempo de execução ele nao ve que é tipo de string, apenas que é um array list
        //Generics só funciona em tempo de compilação

        List<String> Lista = new ArrayList<>();
        Lista.add("String");
        Lista.add("String");
        Lista.add("Willian Suane");

        for(String obj : Lista){
            System.out.println(obj);
        }
        add(Lista, 1L);
    }

    public static void add(List lista, Long l){
        lista.add(l);
    }
}
