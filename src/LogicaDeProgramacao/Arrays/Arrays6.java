package LogicaDeProgramacao.Arrays;

public class Arrays6 {
    public static void main(String[] args) {

        int[][] dias = new int[3][]; //Iniciar array sem definir quantidade de valores
        dias[0] = new int[2]; // colocar valor de cada array
        dias[1] = new int[]{1,2,3}; // colocar valor de cada array
        dias[2] = new int[4]; // colocar valor de cada array

        for(int[] aux : dias) {
            for(int dia : aux) {
                System.out.println(dia);
            }
        }
    }
}
