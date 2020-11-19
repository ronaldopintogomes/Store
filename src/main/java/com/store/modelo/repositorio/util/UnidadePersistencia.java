package com.store.modelo.repositorio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UnidadePersistencia {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("store");
    }

    public static void init() {};

    public static EntityManager getManager() {
        return entityManagerFactory.createEntityManager();
    }
}
