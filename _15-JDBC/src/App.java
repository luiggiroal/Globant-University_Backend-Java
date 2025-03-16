import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        Connection myConnection = null;
        try {
            myConnection = getConnection();
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el conector JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            if (myConnection != null) {
                try {
                    myConnection.close();
                    System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = "vivero";
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        // Loading the Driver class (Mysql driver)
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection myConnection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión exitosa a la base de datos.");

        return myConnection;
    }
}
