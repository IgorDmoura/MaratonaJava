package MaratonaJava.ZZHlambdas.test;


import MaratonaJava.ZZHlambdas.classes.Carro;
import MaratonaJava.ZZHlambdas.interfaces.CarroPredicate;

import java.util.function.Predicate;

public class LambdaTest {
        //Lambda    //Anonima    //Function  //passada por ai  //concisa
        //Carro carro -> carro.getCor().equals("verde");
        //parametros - seta - corpo
        //(String a) -> s.length()
        //(int a, int b) -> (sout(a+b))
    public static void main(String[] args) {
        CarroPredicate carroPredicate =  new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("verde");
            }
        };
        Predicate<Carro> carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
        System.out.println(carroPredicate.test(new Carro("verde",2012)));
        System.out.println(carroPredicate2.test(new Carro("verde",2012)));
        Runnable runnable = () -> System.out.println("Dentro do Run");
        new Thread(runnable).start();



    }
}
