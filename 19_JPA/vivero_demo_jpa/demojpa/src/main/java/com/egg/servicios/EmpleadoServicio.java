package com.egg.servicios;

import com.egg.entidades.Empleado;
import com.egg.entidades.Oficina;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoServicio() {
        empleadoDAO = new EmpleadoDAO();
    }

    public void crearEmpleado(String apellido, int codigoEmpleado,
                              String email, String extension,
                              int idJefe, String nombre,
                              String puesto, Oficina oficina) {
        try {
            Empleado empleado = new Empleado();

            empleado.setApellido(apellido);
            empleado.setCodigoEmpleado(codigoEmpleado);
            empleado.setEmail(email);
            empleado.setExtension(extension);
            empleado.setIdJefe(idJefe);
            empleado.setNombre(nombre);
            empleado.setPuesto(puesto);
            empleado.setOficina(oficina);

            empleadoDAO.guardarEmpleado(empleado);
            System.out.println("\n*** El empleado fue " +
                    "creado exitosamente ***\n");
        } catch (Exception e) {
            System.err.println("\n*** El empleado no fue " +
                    "guardado de forma correcta ***\n");
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        try {
            empleadoDAO.eliminacionEmpleado(idEmpleado);
            System.out.printf("""
                    %n*** El empleado con id %d fue eliminado \
                    exitosamente ***""", idEmpleado);
        } catch (Exception e) {
            System.err.printf("\nEl empleado con id %d no pudo ser eliminado: %s", idEmpleado , e.getMessage());
        }
    }
}
