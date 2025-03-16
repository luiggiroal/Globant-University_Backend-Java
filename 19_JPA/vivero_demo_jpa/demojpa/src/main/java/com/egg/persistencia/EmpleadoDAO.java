package com.egg.persistencia;

import com.egg.entidades.Empleado;
import com.egg.entidades.GamaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EmpleadoDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU", getMapSysEnv());
    EntityManager em = emf.createEntityManager();

    public void guardarEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public Empleado busquedaEmpleado(int idEmpleado) throws Exception {
        return em.find(Empleado.class, idEmpleado);
    }

    public void eliminacionEmpleado(int idEmpleado) throws Exception {
        Empleado empleadoEncontrado = busquedaEmpleado(idEmpleado);
        if (empleadoEncontrado != null) {
            em.getTransaction().begin();
            em.remove(empleadoEncontrado);
            em.getTransaction().commit();
        }
    }
    public Map<String, String> getMapSysEnv() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.password", System.getenv("DB_PASS"));
        return properties;
    }
}
