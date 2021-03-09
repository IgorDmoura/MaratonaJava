package LogicaDeProgramacao.Arrays;

public class Arrays7 {
    public static void main(String[] args) {

        int[][] dias = {{1,2,3},{0,0,0,0},{1,2,3,4,5}}; // 3 arrays iniciados

        for(int[] ref : dias) { // O ref pega o endereço do dias
            for(int dia : ref) { // O dia recebe os valores dos arrays
                System.out.println(dia);
            }
        }
    }
}
