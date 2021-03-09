package MaratonaJava.Kenum.classes;

public enum TipoClienteExer {
       // constant specific class body - sobrescreveu o metodo do juridica mudando o resultado
    PESSOA_JURIDICA(1,"Juridica"){
        public String getId(){
            return "Funcionaaaaaa";
        }
    }, PESSOA_FISICA(2,"Fisica"); // As contantes sempre na primeira linha
    private int tipo;
    private String nome;

    TipoClienteExer(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }

    public String getId(){
        return "A";
    }

}
