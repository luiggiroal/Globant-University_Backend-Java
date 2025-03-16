
package persistencia;
import entidades.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {
//    public ClienteDAO(Connection conexion, Statement statement, ResultSet resultSet) {
//        super(conexion, statement, resultSet);
//    }

    public void guardarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) throw new Exception("El cliente no puede ser nulo");

            String sql = """
                 INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, país, codigo_postal, id_empleado, limite_credito)
                 VALUES
                 (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %.2f)
                 """.formatted(cliente.getCodigoCliente(),
                    cliente.getNombreCliente(), cliente.getNombreContacto(),
                    cliente.getApellidoContacto(), cliente.getTelefono(),
                    cliente.getFax(), cliente.getCiudad(),
                    cliente.getRegion(), cliente.getPais(),
                    cliente.getCodigoPostal(), cliente.getIdEmpleado(),
                    cliente.getLimiteCredito());

            insertarModificarEliminarBD(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTodosLosCliente() throws Exception {
        try {
            String sql = """
                SELECT id_cliente, nombre_contacto, apellido_contacto
                FROM cliente
                """;
            consultarBD(sql);

            Cliente cliente = null;
            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {
                cliente = new Cliente();

                cliente.setIdCliente(resultSet.getInt(1));
                cliente.setNombreContacto(resultSet.getString(2));
                cliente.setApellidoContacto(resultSet.getString(3));

                clientes.add(cliente);
            }

            if (!clientes.isEmpty()) {
                for (Cliente cli : clientes)
                    System.out.println(cli.imprimirIdNombreApellido());
            } else System.out.println("Lista de clientes vacía.\n");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarBD();
        }
    }

    public void buscarClientePorCodigo(int codigoCliente) throws Exception {
        try {
            String sql = """
                SELECT *
                FROM cliente
                WHERE codigo_cliente = %d;
                """.formatted(codigoCliente);

            consultarBD(sql);
            Cliente cliente = null;

            while (resultSet.next()) {
                cliente = new Cliente();

                cliente.setIdCliente(resultSet.getInt(1));
                cliente.setCodigoCliente(resultSet.getInt(2));
                cliente.setNombreCliente(resultSet.getString(3));
                cliente.setNombreContacto(resultSet.getString(4));
                cliente.setApellidoContacto(resultSet.getString(5));
                cliente.setTelefono(resultSet.getString(6));
                cliente.setFax(resultSet.getString(7));
                cliente.setCiudad(resultSet.getString(8));
                cliente.setRegion(resultSet.getString(9));
                cliente.setPais(resultSet.getString(10));
                cliente.setCodigoPostal(resultSet.getString(11));
                cliente.setIdEmpleado(resultSet.getInt(12));
                cliente.setLimiteCredito(resultSet.getDouble(13));
            }

            if (cliente != null) {
                System.out.printf("El cliente con código %d fue encontrado. Esta es su información registrada:\n\n", codigoCliente);
                System.out.println(cliente.toString());
            } else System.out.printf("El cliente con código %d NO fue encontrado.\n", codigoCliente);

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBD();
        }
    }
}
