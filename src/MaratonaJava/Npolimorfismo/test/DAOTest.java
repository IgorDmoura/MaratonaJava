package MaratonaJava.Npolimorfismo.test;

import MaratonaJava.Npolimorfismo.classes.ArquivoDAOImpl;
import MaratonaJava.Npolimorfismo.classes.DatabaseDAOImpl;
import MaratonaJava.Npolimorfismo.classes.GenericDAO;

public class DAOTest {
    public static void main(String[] args) {
        GenericDAO genericDAO = new ArquivoDAOImpl();//Classe maior pode criar objetos da subclasse
        genericDAO.save();
        System.out.println("-----------------------");
        GenericDAO genericDAO1 = new DatabaseDAOImpl();
        genericDAO1.save();
    }
}
