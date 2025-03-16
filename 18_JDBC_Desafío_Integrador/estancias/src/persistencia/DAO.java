package persistencia;

import java.sql.*;

public abstract class DAO {
    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;

    private String host = System.getenv("DB_HOST");
    private String port = System.getenv("DB_PORT");
    private String database = "estancias_exterior";
    private String zone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://%s:%s/%s%s".formatted(host, port, database, zone);
    private String user = System.getenv("DB_USER");
    private String password = System.getenv("DB_PASS");

    protected void connectDB() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("\n*** Successful database connection  ***\n");
        } catch (ClassNotFoundException e) {
            System.err.printf("\n*** Mysql driver not found ***\n%s\n\n", e.getMessage());
            throw e;
        } catch (SQLException e) {
            System.err.printf("\n*** Database access failed ***\n%s\n\n", e.getMessage());
            throw e;
        }
    }

    protected void disconnectDB() throws SQLException {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
            System.out.println("\n*** Successful database disconnection ***\n");
        } catch (SQLException e) {
            System.err.printf("\n*** Failed Disconnection ***\n%s\n\n", e.getMessage());
            throw e;
        }
    }
}
