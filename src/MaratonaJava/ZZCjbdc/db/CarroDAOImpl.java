package MaratonaJava.ZZCjbdc.db;

import MaratonaJava.ZZCjbdc.classes.Carro;
import MaratonaJava.ZZCjbdc.classes.Comprador;
import MaratonaJava.ZZCjbdc.comn.ConexaoFactory;
import MaratonaJava.ZZCjbdc.interfaces.CarroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOImpl implements CarroDAO {
    @Override
    public void save(Carro carro) {
        String sql = "INSERT INTO `agencia`.`carro` (`nome`, `placa` ,`compradorid`) VALUES (? , ? , ?)"; //Comando a ser executado
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);) {
            ps.setString(1, carro.getNome());
            ps.setString(2, carro.getPlaca());
            ps.setInt(3, carro.getComprador().getId());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possivel excluir o arquivo");
            return;
        }
        String sql = "DELETE FROM `agencia`.`carro` WHERE `id` = ?";
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);) {
            ps.setInt(1, carro.getId());
            ps.executeUpdate();
            System.out.println("Registro excluido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possivel atualizar o arquivo");
            return;
        }
        String sql = "UPDATE `agencia`.`carro` SET `placa` = ? , `nome` = ? WHERE `id` = ?";
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getId());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Carro> selectAll() {
        String sql = "select id, nome, placa, compradorid FROM agencia.carro;";
        List<Carro> carroList = new ArrayList<>();
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("compradorid"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));
            }
            return carroList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carro> searchByName(String nome) {
        String sql = "select * FROM agencia.carro where nome LIKE ?";
        List<Carro> carroList = new ArrayList<>();
        try (Connection comn = ConexaoFactory.getConexao();
             PreparedStatement ps = comn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("compradorid"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));
            }
            ConexaoFactory.close(comn, ps, rs);
            return carroList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}


