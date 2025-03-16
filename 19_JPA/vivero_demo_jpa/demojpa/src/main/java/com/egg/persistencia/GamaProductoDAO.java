package com.egg.persistencia;

import com.egg.entidades.GamaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class GamaProductoDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU", getMapSysEnv());
    EntityManager em = emf.createEntityManager();

    public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
        em.getTransaction().begin();
        em.persist(gamaProducto);
        em.getTransaction().commit();
    }

    public GamaProducto busquedaGamaProducto(int idGamaProducto) throws Exception {
        return em.find(GamaProducto.class, idGamaProducto);
    }

    public void modificaGamaProducto(GamaProducto gamaProducto) throws Exception {
        em.getTransaction().begin();
        em.merge(gamaProducto);
        em.getTransaction().commit();
    }

    public Map<String, String> getMapSysEnv() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.password", System.getenv("DB_PASS"));
        return properties;
    }
}
