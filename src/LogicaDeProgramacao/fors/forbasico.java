package LogicaDeProgramacao.fors;

public class forbasico {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("_________________");
            for(int j = 0; j < 10; j++) {
                System.out.println(j);
                if(j==5){
                    break;
                }
            }

    }
}
