package Gestores;

import jakarta.persistence.*;

public class GestorGenerico {
    // variable que guarda fabrica de gestores
    private static final EntityManagerFactory entityManagerFactory;
    //Identificar la unidad de persistencia
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("commercePU");
    }
    //Crear Manager de entidades
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    //Finalizar la contruccion de los Manager
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
