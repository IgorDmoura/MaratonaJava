package MaratonaJava.ZZCjbdc.test;

import MaratonaJava.ZZCjbdc.classes.Comprador;
import MaratonaJava.ZZCjbdc.db.CompradorDBOLD;

import java.sql.SQLException;
import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {
//        System.out.println(CompradorDB.searchByNameRowSet("oao"));
//        CompradorDB.updateRowSet(new Comprador(1,"011.011.011-01","Prepared Statement da Silva"));
//        CompradorDB.updateRowSetcached(new Comprador(1,"011.011.011-01","Prepared Statement da Silva"));
        try {
            CompradorDBOLD.saveTransaction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void inserir() {
        Comprador comprador = new Comprador("111.111.111-22", "Priscila");
        CompradorDBOLD.save(comprador);
    }

    public static void delete() {
        Comprador comprador = new Comprador();
        comprador.setId(3);
        CompradorDBOLD.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador(1, "MARIA", "000.000.000-11");
        CompradorDBOLD.update(comprador);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDBOLD.selectAll();
    }

    public static List<Comprador> buscarPorNome(String nome) {
        return CompradorDBOLD.searchByName(nome);
    }

    }


