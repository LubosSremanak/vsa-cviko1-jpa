import entity.Friend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Friend friend = new Friend();
        friend.setName("Lubos");
        friend.setSurname("Sremanak");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(friend);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
