package MaratonaJava.ZZCjbdc.db;

import MaratonaJava.ZZCjbdc.classes.MyRowSeetListener;
import MaratonaJava.ZZCjbdc.comn.ConexaoFactory;
import MaratonaJava.ZZCjbdc.classes.Comprador;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDBOLD {
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "');"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            stmt.executeUpdate(sql); // Executa o comando do  string sql
            ConexaoFactory.close(comn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void saveTransaction() throws SQLException {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE1', 'TESTE1');"; //Comando a ser executado
        String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE2', 'TESTE2');"; //Comando a ser executado
        String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE3', 'TESTE3');"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        Savepoint savepoint = null;
        try {
            comn.setAutoCommit(false); //Os comandos so serao executados se todos execute foram executados
            Statement stmt = comn.createStatement();
            stmt.executeUpdate(sql);
            savepoint = comn.setSavepoint("One"); //Mesmo falhando os proximos o primeiro fica salvo e sera executado
            stmt.executeUpdate(sql2);
            if(true)
                throw new SQLException();
            stmt.executeUpdate(sql3);
            comn.commit(); //Executra os 3 executes
            ConexaoFactory.close(comn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            comn.rollback(savepoint); //Caso nao ocorra os 3 execute volta pro começo da transacao como se nao tivesse sido executado
            comn.commit();

        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel excluir o arquivo");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE (`id` = '" + comprador.getId() + "')"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            stmt.executeUpdate(sql); // Executa o comando do  string sql
            ConexaoFactory.close(comn, stmt);
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
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = '" + comprador.getCpf() + "', `nome` = '" + comprador.getNome() + "' WHERE (`id` = '" + comprador.getId() + "');"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            stmt.executeUpdate(sql); // Executa o comando do  string sql
            ConexaoFactory.close(comn, stmt);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o arquivo");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ? , `nome` = ? WHERE `id` = ? "; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        try {
            PreparedStatement ps = comn.prepareStatement(sql); // interaje com comando
            ps.setString(1,comprador.getCpf()); //Substituira o primeiro ?
            ps.setString(2, comprador.getNome()); //Substituira o segundo ?
            ps.setInt(3,comprador.getId()); //Substituira o terceiro ?
            ps.executeUpdate(); // Executa o comando do  string sql
            ConexaoFactory.close(comn,ps);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o arquivo");
            return;
        }
//        String sql = "UPDATE `agencia`.`comprador` SET `cpf` = ? , `nome` = ? WHERE `id` = ? "; //Comando a ser executado
        String sql = "SELECT * FROM comprador where id = ? "; //Comando a ser executado
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection(); // conectar server
        jrs.addRowSetListener(new MyRowSeetListener());
        try {
            jrs.setCommand(sql);
//            jrs.setString(1,comprador.getCpf()); //Substituira o primeiro ?
//            jrs.setString(2, comprador.getNome()); //Substituira o segundo ?
            jrs.setInt(1,comprador.getId()); //Substituira o terceiro ?
            jrs.execute();
            jrs.next();
            jrs.updateString("nome", "WILLIAN");
            jrs.updateRow();
            ConexaoFactory.close(jrs);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateRowSetcached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possivel atualizar o arquivo");
            return;
        }
        String sql = "SELECT * FROM comprador where id = ? "; //Comando a ser executado
        CachedRowSet crs = ConexaoFactory.getRowSetConnectioncached(); // conectar server
        try {
            crs.setCommand(sql);
            crs.setInt(1,comprador.getId()); //Substituira o terceiro ?
            crs.execute();
            crs.next();
            crs.updateString("nome", "WWW");
            crs.updateRow();
            Thread.sleep(8000);
//            crs.acceptChanges(); - Pra usar tem que arruma conexao ponde commit accept true
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "select id, nome, cpf FROM agencia.comprador;"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            ResultSet rs = stmt.executeQuery(sql);// Executa o comando do  string sql
            while (rs.next()) { //Começa apontando pro 0, ao usar next desce pro primeiro da lista
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
                System.out.print("ID: ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nome: ");
                System.out.println(rs.getString("nome"));
                System.out.print("CPF: ");
                System.out.println(rs.getString("cpf"));
            }
            ConexaoFactory.close(comn, stmt, rs); //Fecha as conexoes
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String nome) {
        String sql = "select id, nome, cpf FROM agencia.comprador where nome LIKE '%" + nome + "%'";
        //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            ResultSet rs = stmt.executeQuery(sql);// Executa o comando do  string sql
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(comn, stmt, rs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByNamePreparedStatemnt(String nome) {
        String sql = "select id, nome, cpf FROM agencia.comprador where nome LIKE ?";
        //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        List<Comprador> compradorList = new ArrayList<>();
        try {
            PreparedStatement ps = comn.prepareStatement(sql); // interaje com comando
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();// Executa o comando do  string sql
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

    public static List<Comprador> searchByNameRowSet(String nome) {
        String sql = "select id, nome, cpf FROM agencia.comprador where nome LIKE ?";
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection(); // conectar server
        jrs.addRowSetListener(new MyRowSeetListener());
        List<Comprador> compradorList = new ArrayList<>();
        try {
            jrs.setCommand(sql);
            jrs.setString(1, "%" + nome + "%");
            jrs.execute();
            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("cpf"), jrs.getString("nome")));
            }
            ConexaoFactory.close(jrs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByNameCallableStatament(String nome) {
        String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`(?);"; //Puxa a procedure
        //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        List<Comprador> compradorList = new ArrayList<>();
        try {
            CallableStatement cs = comn.prepareCall(sql); // interaje com comando
            cs.setString(1, "%" + nome + "%");
            ResultSet rs = cs.executeQuery();// Executa o comando do  string sql
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(comn, cs, rs);
            return compradorList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void selectMetaData() {
        String sql = "select * FROM agencia.comprador;";
        Connection comn = ConexaoFactory.getConexao(); //Pegar conexao
        try {
            Statement stmt = comn.createStatement(); // interaje com comando
            ResultSet rs = stmt.executeQuery(sql);// Executa o comando do  string sql
            ResultSetMetaData rsmt = rs.getMetaData();
            rs.next();
            int qtdColunas = rsmt.getColumnCount();
            System.out.println("Quantidades Colunas: " + qtdColunas);
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("tabela: " + rsmt.getTableName(i));
                System.out.println("Nome coluna: " + rsmt.getColumnName(i));
                System.out.println("Tamanho coluna: " + rsmt.getColumnDisplaySize(i));
            }
            ConexaoFactory.close(comn, stmt, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void checkDriverStatus() {
        Connection comn = ConexaoFactory.getConexao();
        try {
            DatabaseMetaData dbmd = comn.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) { //Somente pra frente no banco de dados
                System.out.println("Suporta: TYPE_FORWARD_ONLY");
            }
            if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) ;
            {
                System.out.println("E tambem suporta: CONCUR_UPDATABLE ");
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) { //Pra frente e tras mas mudanças nao afetaram o result set
                System.out.println("Suporta: TYPE_SCROLL_INSENSITIVE");
            }
            if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) ;
            {
                System.out.println("E tambem suporta: CONCUR_UPDATABLE ");
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) { // Pra frente e tras e caso result set esteja aberta afetara no banco de dados
                System.out.println("Suporta: TYPE_SCROLL_SENSITIVE");
            }
            if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) ;
            {
                System.out.println("E tambem suporta: CONCUR_UPDATABLE ");
            }
            ConexaoFactory.close(comn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testTypeScroll() { //Métodos para o type scroll insensitive
        String sql = "select id, nome, cpf FROM agencia.comprador;";
        Connection comn = ConexaoFactory.getConexao();
        try {
            Statement stmt = comn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.last()) { //Vai para a ultima linha
                System.out.println("Ultima linha: " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
                System.out.println("Numero da ultima linha: " + rs.getRow()); //Retorna o numero da linha
            }
            System.out.println("Retornou para a primeira linha: " + rs.first()); //Retorna para primeira linha
            System.out.println("Primeira linha: " + rs.getRow());
            rs.absolute(4); //Vai para a linha especificada
            System.out.println("Linha: " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            rs.relative(-1); //Se move em relação a linha que esta, se estava na 4 e seu valor é -1 foi pra linha 3
            System.out.println("Linha: " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            System.out.println(rs.isFirst()); //Verifica se é a primeira linha
            System.out.println(rs.isLast()); //Verifica se é a ultima linha
            rs.afterLast(); //Vai pra após ultima linha, serve pra aparece ultima posicao no caso abaixo:
            while (rs.previous()) { //Mostra toda a lista ao inverso, da atual em forma decrescente até a primeira
                System.out.println(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(comn, stmt, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateNomesToLowerCase() {
        String sql = "select id, nome, cpf FROM agencia.comprador;"; //Comando a ser executado
        Connection comn = ConexaoFactory.getConexao(); // conectar server
        try {
            DatabaseMetaData dbmd = comn.getMetaData();

            Statement stmt = comn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // interaje com comando
            ResultSet rs = stmt.executeQuery(sql);// Executa o comando do  string sql
            System.out.println(dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE)); //Verifica se houve update
            System.out.println(dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE)); //Verifica se houve insert
            System.out.println(dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE)); //Verifica se houve delete

            //Update
            if (rs.next()) { //Começa apontando pro 0, ao usar next desce pro primeiro da lista
                rs.updateString("nome", rs.getString("nome").toUpperCase()); //Coluna + oque fazer com daddos
                rs.cancelRowUpdates(); // Cancela a alteracao feita acima, sempre antes do update row
                rs.updateRow(); // Salvar no banco de dados
            }
//
//            if (rs.rowUpdated()) ;
//            {//Retorna se a coluna foi atualizada
//                System.out.println("Linha atualizada");
//            }

            //Inserir
            rs.absolute(2);
            String nome = rs.getString("nome");
            rs.moveToInsertRow(); //Cria linha temporaria onde pode modificar as colunas
            System.out.println(nome);
            System.out.println(rs.getString("nome"));
            rs.updateString("nome", nome.toUpperCase()); //Coluna a ser mudada + mudança
            rs.updateString("cpf", "999.999.999-99");
            rs.insertRow(); //Inseri essa linha
            rs.moveToCurrentRow(); //Faz a linha temporaria se tornar a linha anterior
            System.out.println(rs.getString("nome") + " row " + rs.getRow());

            //Delete
            rs.absolute(7); //Defini qual linha sera excluida
            rs.deleteRow(); //Exclui a mesma


            ConexaoFactory.close(comn, stmt, rs); //Fecha as conexoes

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
