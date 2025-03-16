package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ClienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU", getMapSysEnv());
    private final EntityManager em = emf.createEntityManager();

    public void guardarCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Map<String , String> getMapSysEnv() {
        Map<String , String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.password", System.getenv("DB_PASS"));
        return properties;
    }
}
