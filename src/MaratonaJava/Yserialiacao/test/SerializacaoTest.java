package MaratonaJava.Yserialiacao.test;

import MaratonaJava.Yserialiacao.classes.Aluno;
import MaratonaJava.Yserialiacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {
    public static void main(String[] args) {
        gravadorObjeto();
        leitorObjeto();
        //Objetos sao serializaveis
        //Staticos nao
        //Nao chama construtor
        //Entao mesmo que a super classe nao seja serializavel, vai serializar

    }

    public static void gravadorObjeto() {
        Turma t = new Turma("Maratona Java, só para os campeões");
        Aluno aluno = new Aluno(1L, "Willian Suane", "123456");
        aluno.setTurma(t);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))) { //Salva um objeto no arquivo
            oos.writeObject(aluno); //Salva um dos objeto no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leitorObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))) { //Salva um objeto no arquivo
            Aluno aluno = (Aluno) ois.readObject(); //Salva um dos objeto no arquivo
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

