package MaratonaJava.ZZHlambdas.test;

import MaratonaJava.ZZHlambdas.classes.Carro;
import MaratonaJava.ZZHlambdas.classes.ComparadorCarro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest3 {
    public static void main(String[] args) {
        //Method references - Criado para facilitar a leitura das lambdas

        //System.out::println - Imprimi valores do array
        forEach(asList("Willian","DevDojo","facebook.com/devdojobr"), System.out::println);

        //1 - Referencia para um static Method
        List<Carro> carros = asList(new Carro("Vermelho",1999),new Carro("Azul",2005),new Carro("Preto",1985));
        Collections.sort(carros, ComparadorCarro::comparePorCor); //Lista + classe com mesmo metodo + metodo
        System.out.println(carros);

        //2 - Referencia para um instance method of a particular object
        ComparadorCarro comparadorCarro = new ComparadorCarro();
        Collections.sort(carros, comparadorCarro::comparePorAno); // lista + classe :: método
        System.out.println(carros);

        //3- Referencia to an instace method of an arbitrary object of a particular type
        //Trabalhar diretamente com a classe e com objetos nao estaticos
        List<String> nomes = asList("Willian","DevDojo","Anna","Brenon");
        nomes.sort((s1, s2) -> s1.compareTo(s2));
        nomes.sort(String::compareTo); //Chamar apenas 1 metodo no lambda, ele usa o padrao o de cima no caso
        System.out.println(nomes);
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s); //Pega um string e devolve o integer
        Function<String, Integer> stringToInteger2 =Integer::parseInt; //Pega um string e devolve o integer , com method references

        BiPredicate<List<String>, String> contains = (lista, elemento) -> lista.contains(elemento); //Verifica se a lista possui a string
        BiPredicate<List<String>, String> contains2 = List::contains; //Verifica se a lista possui a string
        System.out.println(contains2.test(nomes,"Willian")); //Verifica se tem o nome da lista

        System.out.println(stringToInteger.apply("10")); //Transforma string em integer

        //4- Reference to a constructor - Cria objeto
        Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new; //Criou objeto com method references
//        System.out.println(comparadorCarroSupplier.get().comparePorAno()); //Pode usar o objeto criado

        //Usando o Suplier no exemplo 2

        //2 - Referencia para um instance method of a particular object -Suplier
        ComparadorCarro comparadorCarro2 = new ComparadorCarro();
        Supplier<ComparadorCarro> comparadorCarroSupplier2 = ComparadorCarro::new; //Criou objeto com method references
        Collections.sort(carros, comparadorCarroSupplier2.get()::comparePorAno); // lista + classe :: método
        System.out.println(carros);

        //Ainda necessita de 2 argumento, porque no construtor carro tem 2
        BiFunction<String, Integer, Carro> carroBiFunction = (s ,i) -> new Carro(s,i); //Pega um string e integer e retorna um carro
        System.out.println(carroBiFunction.apply("rosa",1994)); //coloca valores dos mesmos, instancia o carro
        
        //Usando o method references
        BiFunction<String, Integer, Carro> carroBiFunction2 =Carro::new; //Pega um string e integer e retorna um carro
        System.out.println(carroBiFunction2.apply("vermelho",1995)); //coloca valores dos mesmos, instacia o carro


















    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T e : list){
            c.accept(e); //Recebe os dados da lista
        }
    }
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T e : list){
            result.add(f.apply(e));
        }
        return result;
    }
}

