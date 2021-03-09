package MaratonaJava.Bintroduçãometodos.classes;

public class Estudante {
    private String nome;
    private int idade;
    private double[] notas;
    private boolean aprovado;

    public void informacoesAluno() {
        System.out.println("Nome do aluno: " + this.nome);
        System.out.println("Idade do aluno: " + this.idade);
        if (this.notas != null) {
            double somanotas = 0;
            for (double num : this.notas) {
                somanotas += num;
            }

            somanotas = somanotas / this.notas.length;

            System.out.println("Média do Aluno: " + somanotas);
            if (somanotas > 6) {
                aprovado = true;
                System.out.println("Aluno Aprovado");
            } else {
                aprovado = false;
                System.out.println("Aluno Reprovado");
            }
        }
    }

    //Getters and Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("Você não pode fazer isso");
        }
        this.idade = idade;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getNotas() {
        return this.notas;
    }

    public boolean isAprovado() {
        return this.aprovado;
    }
}

//Valores booleanos usar Is ao inves de get
//Set serve para modificar o argumento(conteudo)
//Se tiver sido criado, é possivel altera-lo
//Se tiver apenas o Get, o valor nao pode ser alterado
//Apenas pego daqui mesmo(Nesse caso no tirar media)

