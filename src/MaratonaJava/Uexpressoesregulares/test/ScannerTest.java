package MaratonaJava.Uexpressoesregulares.test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 100 oi"); //Delimitador padrão é o espaço
        while (scanner.hasNext()) {                //Enquanto houver proximo espaçamento
            System.out.println(scanner.next()); //Imprima o proximo token
        }

        System.out.println("#######################");
        Scanner scanner2 = new Scanner("1 true 100 oi");
        while (scanner2.hasNext()){
            if(scanner2.hasNextInt()){
                int i = scanner2.nextInt();
                System.out.println("int " + i);
            }else if(scanner2.hasNextBoolean()){
                boolean b = scanner2.nextBoolean();
                System.out.println("boolean " + b);
            }else{
                System.out.println("String " + scanner2.next());
            }
        }



    }
}
