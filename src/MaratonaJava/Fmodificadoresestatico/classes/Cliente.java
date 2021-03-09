package MaratonaJava.Fmodificadoresestatico.classes;

public class Cliente {
    //0 - Bloco de Inicialização estatico é executado quando a JVM carregar a classe.z
    //1 - Alocado espaço na memória para o objeto que será criado
    //2 - Cada atributo da classe é criado e inicializado com seus valores default ou explicitos
    //3 - Bloco de Inicializacao é executado
    //4 - O Construtor é executado

    private static int[] parcelas;

    static { //Bloco de inicializacao estatico só inicializa uma vez
        parcelas = new int[100];
        System.out.println("Dentro do Bloco de Inicialização");
        for (int i =1; i <=100; i++) {
            parcelas[i-1] = i;
        }
    }

 //Quando há mais de um bloco estatico eles sao executados em ordem, e uma unica vez cada
//Bloco de inicializacao nao estatico acessa atributos de classe estaticos
//Bloco Estatico executa uma vez, bloco nao estatico executa conforme quantidade de objetos



    public Cliente() {
    }

    public static int[] getParcelas() {
        return parcelas;
    } //Nao precisa de set porque o bloco de inicializacao
    //Ja esta iniciando o valor
}
