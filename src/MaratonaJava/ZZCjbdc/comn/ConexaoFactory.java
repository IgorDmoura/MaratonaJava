package MaratonaJava.ZZCjbdc.comn;


import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class ConexaoFactory {

    public static Connection getConexao() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            return DriverManager.getConnection(url, user, password); //Joga os dados pra fazer login
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null; //Caso nao de ele retorna null
    }

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static CachedRowSet getRowSetConnectioncached() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            return cachedRowSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void close(Connection connection) {
        try {
            if(connection != null)
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(RowSet jrs) {
        try {
            if(jrs != null)
                jrs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(Connection connection, Statement stmt){
        close(connection);
        try {
            if(stmt != null)
                stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement stmt, ResultSet rs){
        close(connection,stmt);
        try {
        if(rs != null)
            rs.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
}
