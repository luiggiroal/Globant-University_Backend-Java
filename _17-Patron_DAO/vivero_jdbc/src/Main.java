import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.ProductoDAO;
import servicios.ClienteServicio;

public class Main {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        Cliente cliente = new Cliente();
        ClienteServicio clienteServicio = new ClienteServicio();

//        for (int i = 1; i <= 5; i++) {
//            cliente.setCodigoCliente((int) (Math.random() * (999 - 100 + 1) + 100));
//            cliente.setNombreCliente("NombreCliente %d".formatted(i));
//            cliente.setNombreContacto("NombreContacto %d".formatted(i));
//            cliente.setApellidoContacto("ApellidoContacto %d".formatted(i));
//            cliente.setTelefono("99250000%d".formatted(i));
//            cliente.setFax("80050000%d".formatted(i));
//            cliente.setCiudad("Ciudad %d".formatted(i));
//            cliente.setRegion("Region %d".formatted(i));
//            cliente.setPais("País %d".formatted(i));
//            cliente.setCodigoPostal("550%d".formatted(i));
//            cliente.setIdEmpleado(1);
//            cliente.setLimiteCredito(25000.00);
//
//            clienteDAO.guardarCliente(cliente);
//        }
//
//        clienteDAO.listarTodosLosCliente();

//        productoDAO.eliminarProductoPorCodigo(4);

//        clienteDAO.buscarClientePorCodigo(10);

//        clienteServicio.crearNuevoCliente(20, "DH", "Luiggi",
//                "Rodriguez", "22222", "44444", "Lima",
//                "Lima", "Peru", "17044", 3, 1999.99);
//        clienteServicio.crearNuevoCliente(20, "DH", "Luis",
//                null, "22222", "44444", "Lima",
//                "Lima", "Peru", "17044", 3, 1999.99);

//        clienteDAO.listarTodosLosCliente();
    }
}
