package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO gamaProductoDAO;

    public GamaProductoServicio() {
        gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionHtml, String descripcionTexto,
                                  String gama, String imagen) {
        try {
            GamaProducto gamaProducto = new GamaProducto();

            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setGama(gama);
            gamaProducto.setImagen(imagen);

            gamaProductoDAO.guardarGamaProducto(gamaProducto);
            System.out.println("\n*** La gama del producto fue " +
                    "creada exitosamente ***\n");
        } catch (Exception e) {
            System.err.println("\n*** La gama del producto no fue " +
                    "guardada de forma correcta ***\n");
        }
    }

    public GamaProducto buscarGamaProducto(int idGamaProducto) {
        try {
            GamaProducto gamaProducto = gamaProductoDAO.busquedaGamaProducto(idGamaProducto);
            if (gamaProducto == null)
                System.out.println("\n*** No existe una de gama de producto de id " + idGamaProducto + " ***\n");
            else {
                System.out.printf("""
                        %n*** Búsqueda de gama de producto con id %d exitosa ***%n
                        """, idGamaProducto);
            }
            return gamaProducto;
        } catch (Exception e) {
            System.err.printf("Error al buscar la gama de producto: %s", e.getMessage());
        }
        return null;
    }

    public void actualizarGamaProducto(int idGamaProducto, String gama) {
        GamaProducto gamaProductoEncontrado = buscarGamaProducto(idGamaProducto);
        if (gamaProductoEncontrado == null) return;

        gamaProductoEncontrado.setGama(gama);

        try {
            gamaProductoDAO.modificaGamaProducto(gamaProductoEncontrado);
            System.out.printf("""
                        %n*** Actualización de gama de producto con id %d exitosa ***%n
                        """, idGamaProducto);
        } catch (Exception e) {
            System.err.printf("Error al modificar la gama de producto: %s", e.getMessage());
        }
    }
}
