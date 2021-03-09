package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Celular;

public class EqualsTest {
    public static void main(String[] args) {
        String nome1 = "Willian Suane";
        String nome2 = new String("Willian Suane");
        Integer int1 = 5;
        Integer int2 = new Integer(5);
        System.out.println(nome1.equals(nome2));
        System.out.println(int1.equals(int2));

        Celular c1 = new Celular("Iphone","1234");
        Celular c2 = new Celular("Iphone","1234");
        //Ele retornou false porque ta comparando o endereço de memória e nao o conteudo das strings
        //Porem ao sobrescrever o método Equals na classe celular, retorna true pois ele compara o string IMEI
        System.out.println(c1.equals(c2));
    }
}
