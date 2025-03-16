package com.egg;

import com.egg.entidades.Empleado;
import com.egg.entidades.GamaProducto;
import com.egg.entidades.Oficina;
import com.egg.servicios.ClienteServicio;
import com.egg.servicios.EmpleadoServicio;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        OficinaServicio oficinaServicio = new OficinaServicio();
        GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();

//        oficinaServicio.crearOficina("Mendoza", "CP5000",
//                "OFI01", "Argentina", "Cuyo",
//                "111111111");

//        gamaProductoServicio.crearGamaProducto("foo html", "this description",
//                "alta", "logo.png");

//        GamaProducto gamaProductoEncontrado = gamaProductoServicio.buscarGamaProducto(4);
//        System.out.println(gamaProductoEncontrado.toString());

//        gamaProductoServicio.actualizarGamaProducto(6, "Utilitarias");

    }
}
