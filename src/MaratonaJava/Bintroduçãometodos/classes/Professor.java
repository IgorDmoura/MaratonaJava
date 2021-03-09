package MaratonaJava.Bintroduçãometodos.classes;

public class Professor {
    public String cpf;  //Valores aqui
    public String matricula; //Valores aqui
    public String nome; //Valores aqui
    public String rg; //Valores aqui

    public void imprime() {
        System.out.println("_______________________");
        System.out.println(this.cpf); //This se refere ao valor acima
        System.out.println(this.matricula); //This se refere ao valor acima
        System.out.println(this.nome); //This se refere ao valor acima
        System.out.println(this.rg); //This se refere ao valor acima

        //This pegar valores do proprio objeto automaticamente
    }
}




