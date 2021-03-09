package MaratonaJava.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversaoDeListasArraysTeste {
    public static void main(String[] args) {

       //De lista para Array
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        Integer[] numerosArray = new Integer[numeros.size()];
        numeros.toArray(numerosArray); //Passa os dados do list para o numeros array
        System.out.println(numeros);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println("------------------------");

        //De Array para lista
        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 10;
        numerosArray2[1] = 9;
        numerosArray2[2] = 8;
        numerosArray2[3] = 7;
        List<Integer> numeros2 = Arrays.asList(numerosArray2); //Transforma o Array Em List
        //Porem os 2 ficam no mesmo local, e se alterar algo em um no outro tambem ira alterar
        //Para resolver isso cria-se outra lista e passa a lista criada na conversão (Arrays.asList(numerosArray2)

        List<Integer> numeros3= new ArrayList<>(); //Criar Lista nova
        numeros3.addAll(Arrays.asList(numerosArray2)); //Passa lista da conversão

        numeros2.set(0,1); //Essa alteração ira afetar numeros e numeros2, porem a nova e separada 3 nao

        System.out.println(Arrays.toString(numerosArray2)); //Com alteração
        System.out.println(numeros2); //Com alteração
        System.out.println(numeros3); //Sem alteração


    }
}
