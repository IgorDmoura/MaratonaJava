package MaratonaJava.ZZCjbdc.db;

import MaratonaJava.ZZCjbdc.classes.Comprador;
import MaratonaJava.ZZCjbdc.comn.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES (? , ?)"; //Comando a ser executado
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel excluir o arquivo");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id` = ?";
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);) {
            ps.setInt(1, comprador.getId());
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o arquivo");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ? , `nome` = ? WHERE `id` = ?";
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "select id, nome, cpf FROM agencia.comprador;";
        List<Comprador> compradorList = new ArrayList<>();
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String nome) {
        String sql = "select id, nome, cpf FROM agencia.comprador where nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(comn, ps, rs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Comprador searchById(Integer id) {
        String sql = "select id, nome, cpf FROM agencia.comprador where id = ?";
        Comprador comprador = null;
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comprador = new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"));
            }
            ConexaoFactory.close(comn, ps, rs);
            return comprador;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
