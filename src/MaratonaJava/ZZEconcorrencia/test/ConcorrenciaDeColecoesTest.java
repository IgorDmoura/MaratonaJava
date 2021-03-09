package MaratonaJava.ZZEconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConcorrenciaDeColecoesTest {
    public static void main(String[] args) {
        //ConcurrentHashMap
        //ConcurrentLinkedDeque - Sincronizados
        //ConcurrentLinkedQueue - Sincronizados
        //ConcurrentSkipListMap - Sortido
        //ConcurrentSkipListSet - Sortido
        //Não mantem o estado de como obteve o objeto ao iterar
        //Multiplas Threads escrevendo concurrentemente pra essa colecao
        //sem ter que criar multiplas copias internas de uma coleção
        //Mais rapido que o copyonwrite

        Map<String,String> map = new LinkedHashMap<>();
        map.put("1","1");
        map.putIfAbsent("1","2"); //Só colocar se nao tiver chave igual a essa
        System.out.println(map.get("1"));
    }
}
