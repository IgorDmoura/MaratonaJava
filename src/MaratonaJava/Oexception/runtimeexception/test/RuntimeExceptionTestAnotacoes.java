package MaratonaJava.Oexception.runtimeexception.test;

public class RuntimeExceptionTestAnotacoes {
    public static void main(String[] args) {
//        int a = 10;
//        int b = 0;
//        if (b != 0) {
//            int c = a / b;
//            System.out.println(a);
//            System.out.println("-----------------------");
//            Object o = null;
//            System.out.println(o.toString());
        try {
            int[] a = new int[2]; // foi criado um array com posição 0 e 1
            System.out.println(a[2]); // tentaram chamar posicao 2 e deu erro
        } catch (ArrayIndexOutOfBoundsException e) { // Caso o erro fosse o runtimeexception ele fara o catch
            e.printStackTrace(); // foi executado catch, o printstacktrace mostra o codigo de erro e continua o programa, ignorando o codigo que da erro
        }
        System.out.println("Quando voce usa o try e catch, mesmo que de erro, o programa contnua sendo executado normalmente");

    }
}

//Se nao tivesse feito esse tratamento com o try catch, a jvm nao executaria o programa
//E o programa pararia de funcionar.

//O erro foi IndexoutofbondException, mas ali no catch pode colocar Runtimeexception pois é uma super classe de IndexoutofbondException
//Porem o certo é usar a classe mais especifica possivel, ou seja a ArrayIndexOutOfBoundsException nesse caso
//Póis quando mais especifico o erro, mais detalhes sobre o mesmo terá

