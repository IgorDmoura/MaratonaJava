package MaratonaJava.ZZHlambdas.test;

import MaratonaJava.ZZHlambdas.classes.Carro;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest2 {
    public static void main(String[] args) {
        forEach(asList("Willian","DevDojo","facebook.com/devdojobr"),(String s) -> System.out.println(s));
        List<Integer> list = map(asList("Willian","DevDojo","facebook.com/devdojobr"), (String s) -> s.length());
        List<Carro> carros = asList(new Carro("Preto",2011),new Carro("Preto",2011),new Carro("Preto",2011));
        List<String> listCores = map(carros, (Carro c) -> c.getCor());
        System.out.println(listCores);
        System.out.println(list);
        Predicate<Integer> pares = (Integer i) -> i % 2 ==0; //Retorna true caso seja verdadeiro
        System.out.println(pares.test(1000)); // Mostra os pares
        IntPredicate impar = (int i) -> i % 2==1;
        System.out.println(impar.test(1000)); //Verifica impar, usando intpredicate mais rapido
        Callable<Integer> c = () -> 100;
        PrivilegedAction<Integer> pa = () -> 100;

        String cor = "vermelho"; //Pode usar variavel local desde que nunca mude o valor da mesma, efetivamente final
        Predicate<String> p = s -> listCores.add(s); //Retorna bolleano
//        p.test("amarelo");
        System.out.println(listCores);
        Consumer<String> b = s -> listCores.add(cor); //Retorna void
        b.accept("amarelo");
        Supplier<String> sup1  = () -> "oi"; //Retorna oque estiver como T, seja string, carro etc
        Supplier<Carro> sup2  = () -> new Carro("Preto",2011);
//        System.out.println(listCores);
        System.out.println(sup2.get());


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
