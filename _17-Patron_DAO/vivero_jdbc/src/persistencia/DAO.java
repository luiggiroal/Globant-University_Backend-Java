package persistencia;

import java.sql.*;

public abstract class DAO {
    protected Connection conexion = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;

    private String host = System.getenv("DB_HOST");
    private String port = System.getenv("DB_PORT");
    private String database = "vivero";
    private String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://%s:%s/%s%s".formatted(host, port, database, zona);
    private String user = System.getenv("DB_USER");
    private String password = System.getenv("DB_PASS");

//    public DAO(Connection conexion, Statement statement, ResultSet resultSet) {
//        this.conexion = conexion;
//        this.statement = statement;
//        this.resultSet = resultSet;
//    }

    protected void conectarBD() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("\n*** Conexión exitosa a la base de datos ***\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void desconectarBD() throws SQLException {
        try {
            if (conexion != null) conexion.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
            System.out.println("\n*** La desconexión a la base de datos fue exitosa ***\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void insertarModificarEliminarBD(String sql) throws Exception {
        try {
            conectarBD();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);
//            System.out.println("Inserción/Modificación/Eliminación exitosa.\n");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            desconectarBD();
        }
    }

    protected void consultarBD(String sql) throws Exception {
        try {
            conectarBD();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
//            System.out.println("Consulta exitosa.\n");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
