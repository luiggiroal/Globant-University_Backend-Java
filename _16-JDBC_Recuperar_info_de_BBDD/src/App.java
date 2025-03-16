import java.sql.*;

public class App {
    public static void main(String[] args) {
        Connection conexion = getConnection();

        buscarClientes(conexion);
        buscarClientesPorCodigo(conexion, 11);
        buscarClientesPorEmpleado(conexion, 9);

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

    public static void buscarClientes(Connection conexion) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente";
        System.out.println();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void buscarClientesPorCodigo(Connection conexion, int codigo) {
        String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigo;
        System.out.println("\nInformación completa de clientes con código " + codigo + ":\n");

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            int count = 0;

            while (rs.next()) {
                count++;
                System.out.printf("%s)", count);
                for (int i = 1; i <= columnCount; i++) {
                    int columnType = metaData.getColumnType(i);
                    if (columnType == Types.INTEGER)
                        System.out.printf(" %s /", rs.getInt(i));
                    else
                        System.out.printf(" %s /", rs.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void buscarClientesPorEmpleado(Connection conexion, int codigo) {
        String sql = """
                SELECT
                    id_cliente ID,
                    nombre_cliente Empresa,
                    concat(nombre_contacto, ' ', apellido_contacto) Contacto,
                    ciudad  Ciudad,
                    país País
                FROM cliente
                WHERE id_empleado = %d
                """.formatted(codigo);
        System.out.println("\n* Información de clientes asociados al empleado con id " + codigo + ":\n");

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int count = 0;
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                count++;
                System.out.println("---------------------------");
                System.out.println("N° Cliente: " + count);

                for (int i = 1; i <= columnCount; i++) {
                    int columnType = metaData.getColumnType(i);
                    String columnName = metaData.getColumnLabel(i);
                    if (columnType == Types.INTEGER)
                        System.out.println(columnName + ": " + rs.getInt(i));
                    else
                        System.out.println(columnName + ": " + rs.getString(i));
                }
                System.out.println("---------------------------\n");
            }
            if (count == 0)
                System.out.println("No se encontraron clientes asociados a este empleado");
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }
}



