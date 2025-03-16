import java.sql.*;

public class App {
    public static void main(String[] args) {
        Connection conexion = getConnection();
        getColumnsComplete(conexion, "cliente");
//        getColumns(conexion, "cliente");
        cerrarConexion(conexion);
    }
    public static Connection getConnection() {
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = "vivero";
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("\nConexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nError al cargar el conector JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("\nError de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("\nLa conexión a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("\nError al cerrar la conexión:" + e.getMessage());
            }
        }
    }

    public static void getColumnsComplete(Connection conexion, String tabla) {
        String sql = """
                TABLE %s
                """.formatted(tabla);
        System.out.printf("* Columnas y tipo de dato de la tabla \'%s\':\n\n", tabla);

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                String columnTypeName = metaData.getColumnTypeName(i);
                boolean isAutoIncrement = metaData.isAutoIncrement(i);

                if (columnTypeName.equalsIgnoreCase("DECIMAL")) {
                    int precision = metaData.getPrecision(i); // Total number of digits
                    int scale = metaData.getScale(i); // Total number of digits after the decimal point

                    System.out.printf(" %s; %s(%d, %d)\n", columnName, columnTypeName, precision, scale);
                } else if (isAutoIncrement) {
                    System.out.printf(" %s; %s AUTO_INCREMENT\n", columnName, columnTypeName);
                } else
                    System.out.printf(" %s; %s\n", columnName, columnTypeName);

//                System.out.println(columnName + " = %f");
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }


    public static void getColumns(Connection conexion, String tabla) {
        String sql = """
                TABLE %s
                """.formatted(tabla);
        System.out.printf("* Columnas y tipo de dato de la tabla \'%s\':\n\n", tabla);

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName + " = %f");
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }
}
