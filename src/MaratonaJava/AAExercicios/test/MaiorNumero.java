package MaratonaJava.AAExercicios.test;

public class MaiorNumero {
    public static void main(String[] args) {
        maiorNumero(10,15);
    }

    public static void maiorNumero(int a, int b){
        if(a > b){
            System.out.println("O valor de A é maior que B");
        }else{
            System.out.println("O valor de B é maior que A");
        }
    }
}

