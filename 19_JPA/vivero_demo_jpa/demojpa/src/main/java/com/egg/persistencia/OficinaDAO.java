package com.egg.persistencia;

import com.egg.entidades.Oficina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class OficinaDAO {
    private final String dbUser = System.getenv("DB_USER");
    private final String dbPassword = System.getenv("DB_PASS");

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU", getMapSysEnv());
    private final EntityManager em = emf.createEntityManager();

    public void guardarOficina(Oficina oficina) throws Exception {
        em.getTransaction().begin();
        em.persist(oficina);
        em.getTransaction().commit();
    }

    public Map<String, String> getMapSysEnv() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.user", dbUser);
        properties.put("jakarta.persistence.jdbc.password", dbPassword);
        return properties;
    }
}
