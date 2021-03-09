package MaratonaJava.Eblocodeinicializacao.classes;

public class Cliente {
    //1 - Alocado espaço na memória para o objeto que será criado
    //2 - Cada atributo da classe é criado e inicializado com seus valores default ou explicitos
    //3 - Bloco de Inicializacao é executado
    //4 - O Construtor é executado

    private int[] parcelas;
    {
        parcelas = new int[100];
        System.out.println("Dentro do Bloco de Inicialização");
        for (int i =1; i <=100; i++) {
            parcelas[i] = i;
        }

    }
    public Cliente() {
    }

    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
