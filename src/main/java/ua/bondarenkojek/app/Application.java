package ua.bondarenkojek.app;


import ua.bondarenkojek.models.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Application {


    public static void main(String[] args) {


        EntityManager manager = getEm();




       // Task task = new Task(new Date(), "Test task");



        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

//        manager.persist(task);

//        transaction.commit();


        manager.close();

        emf.close();


    }

    private static final String PERSISTENT_UNIT_NAME = "taskUnit";

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
