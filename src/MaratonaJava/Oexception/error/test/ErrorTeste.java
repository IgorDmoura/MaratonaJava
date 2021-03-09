package MaratonaJava.Oexception.error.test;

public class ErrorTeste {
    public static void main(String[] args) {
        stackOverflowError();
    }
    public static void stackOverflowError(){
        stackOverflowError();
    }
}
