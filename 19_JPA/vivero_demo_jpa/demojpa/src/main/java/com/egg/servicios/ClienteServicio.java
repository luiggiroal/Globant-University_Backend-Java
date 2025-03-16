package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {
    private final ClienteDAO clienteDAO;

    public ClienteServicio() {
        clienteDAO = new ClienteDAO();
    }

    public void crearServicio(String apellidoContacto, String ciudad, int codigoCliente,
                              String codigoPostal, String fax,
                              double limiteCredito, String nombreCliente,
                              String nombreContacto, String pais,
                              String region, String telefono, Empleado empleado) {

        try {
            Cliente cliente = new Cliente();

            cliente.setApellidoContacto(apellidoContacto);
            cliente.setCiudad(ciudad);
            cliente.setCodigoCliente(codigoCliente);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setFax(fax);
            cliente.setLimiteCredito(limiteCredito);
            cliente.setNombreCliente(nombreCliente);
            cliente.setNombreContacto(nombreContacto);
            cliente.setPais(pais);
            cliente.setRegion(region);
            cliente.setTelefono(telefono);
            cliente.setEmpleado(empleado);

            clienteDAO.guardarCliente(cliente);
            System.out.println("\n*** El cliente fue " +
                    "creado exitosamente ***\n");
        } catch (Exception e) {
            System.err.println("\n*** El cliente no fue " +
                    "guardado de forma correcta ***\n");
        }
    }
}
