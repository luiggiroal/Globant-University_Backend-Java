package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO clienteDAO;

    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    public Cliente crearNuevoCliente(int codigoCliente, String nombreCliente,
                                     String nombreContacto, String apellidoContacto,
                                     String telefono, String fax, String ciudad,
                                     String region, String pais, String codigoPostal,
                                     int idEmpleado, double limiteCredito) throws Exception {
//     Validaciones
        validacionesNyA(nombreContacto, apellidoContacto);

        Cliente cliente = new Cliente(codigoCliente, nombreCliente, nombreContacto, apellidoContacto,
                telefono, fax, ciudad, region, pais, codigoPostal, idEmpleado, limiteCredito);

        clienteDAO.guardarCliente(cliente);
        return cliente;
    }

    public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception {
        if (nombreContacto == null) throw new Exception("El nombre del contacto no puede ser nulo");
        if (apellidoContacto == null) throw new Exception("El apellido del contacto no puede ser nulo");
    }
}
