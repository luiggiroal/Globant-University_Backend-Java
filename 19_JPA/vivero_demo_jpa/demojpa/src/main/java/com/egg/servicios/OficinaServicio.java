package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

public class OficinaServicio {
    private final OficinaDAO oficinaDAO;

    public OficinaServicio() {
        oficinaDAO = new OficinaDAO();
    }

    public void crearOficina(String ciudad, String codigoPostal,
                             String codigoOficina, String pais,
                             String region, String telefono) {
        try {
            Oficina oficina = new Oficina();

            oficina.setCiudad(ciudad);
            oficina.setCodigoPostal(codigoPostal);
            oficina.setCodigoOficina(codigoOficina);
            oficina.setPais(pais);
            oficina.setRegion(region);
            oficina.setTelefono(telefono);

            oficinaDAO.guardarOficina(oficina);
            System.out.println("\n*** La oficina fue " +
                    "creada exitosamente ***\n");
        } catch (Exception e) {
            System.err.println("\n*** La oficina no fue " +
                    "guardada de forma correcta ***\n");
        }
    }
}
