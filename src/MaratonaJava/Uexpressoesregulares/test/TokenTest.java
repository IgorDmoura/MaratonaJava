package MaratonaJava.Uexpressoesregulares.test;

public class TokenTest {
    public static void main(String[] args) {
        String str = "Willian, Paulo, Joana, Camila, Anna, John, Mateus";
        String[] tokens = str.split(","); //Dividi a string, separando elas pela virgula
        for(String tk : tokens){
            System.out.println(tk.trim());
        }
    }
}
