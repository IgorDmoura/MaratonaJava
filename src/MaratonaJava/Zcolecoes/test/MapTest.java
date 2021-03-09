package MaratonaJava.Zcolecoes.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        //Ele sempre pede Chave e valor
        Map<String, String> map = new LinkedHashMap<>(); //Hash nao garante ordem que estara organizado os elementos
        //Se mudar o new HashMap para new LinkedHashMap, ele mantem a ordem de inserção
        map.put("teklado","teclado");
        map.put("mouze","mouse");
        map.put("vc","você");
        map.put("meza","mesa");
        //Pode iterar tanto na chave quanto no valor
//        for(String key : map.values()){ //Map.keyset mostra as keys, map.values mostra os valores
//            System.out.println(key);
//        }
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
