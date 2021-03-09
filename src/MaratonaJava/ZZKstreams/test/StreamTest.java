package MaratonaJava.ZZKstreams.test;

import MaratonaJava.ZZKstreams.classes.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    //Pegar os 3 primeiros nomes das pessoas com menos de 25 anos
    //Ordenados pelo nome
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Collections.sort(pessoas, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
        List<String> nomes = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getIdade() < 25) {
                nomes.add(pessoa.getNome());
                if (nomes.size() >= 3) {
                    break;
                }
            }
        }
        System.out.println(nomes);
        //Streams vai ser algo em tempo real e colecoes guardado em algum lugar
        //Colecacao guarda dados
        //Stream transforma em algo computa os dados

        List<String> nomes2 = pessoas
                .stream() //Fazer stream
                .filter(p -> p.getIdade() < 25) //Filtra pessoas menor 25
                .sorted(Comparator.comparing(Pessoa::getNome)) //Compara pessoas
                .limit(3) //Limita a 3
                .skip(1) //Pula o primeiro
                .map(Pessoa::getNome) //Pega dados
                .collect(Collectors.toList()); //Transforma em lista
        System.out.println(nomes2);

        System.out.println(pessoas
                .stream() //Fazer stream
                .distinct() //Nao conta pessoas repetidas
                .filter(p -> p.getIdade() < 25) //Filtra pessoas menor 25
                .map(Pessoa::getNome) //Pega dados
                .count());

        pessoas.stream().forEach(System.out::println);


        //Intermediate - Retornar outro stream - Stream, filter sorted...
        //Terminal - Retorna valor final - collect, count, foreach
    }
}
