package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Celular;


import java.util.ArrayList;
import java.util.List;

public class CelularTest {
    public static void main(String[] args) {
        Celular celular1 = new Celular("Galaxy S7","123456");
        Celular celular2 = new Celular("Iphone 6S","961821");
        Celular celular3 = new Celular("Sony Xperia","019212");

        List<Celular> celularList = new ArrayList<>();
        celularList.add(celular1);
        celularList.add(celular2);
        celularList.add(celular3);

        for(Celular celular : celularList){
            System.out.println(celular);
        }
        Celular celularpesquisa = new Celular("Galaxy S7","123456");
        System.out.println(celularList.contains(celularpesquisa)); //Procurar celular na lista do array

    }
}
