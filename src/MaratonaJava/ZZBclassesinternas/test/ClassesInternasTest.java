package MaratonaJava.ZZBclassesinternas.test;

public class ClassesInternasTest {
    private String nome = "Willian Jedai do Devdojo";

    class Interna {
        public void verClasseExterna() {
            System.out.println(nome);
            System.out.println(this); //Esse this se refere ao da classe interna
            System.out.println(ClassesInternasTest.this); //Esse this se refere ao da classe externa
        }
    }


    public static void main(String[] args) {
        ClassesInternasTest externa = new ClassesInternasTest(); //Cria objeto classe externa
        ClassesInternasTest.Interna in = externa.new Interna(); //Cria objeto da classe interna - Externa.interna
        ClassesInternasTest.Interna in2 = new ClassesInternasTest().new Interna(); //Outra forma de criar
        in.verClasseExterna();
//        in2.verClasseExterna();

    }
}

//class Externa {
//    private String nome  = "Willian Jedai do Devdojo";
//
//    class Interna{ //Classe interna fica dentro da interna, é como se fosse um método, tem acesso aos atributos da externa
//        public void verClasseExterna(){
//            System.out.println(nome);
//        }
//    }
//}



