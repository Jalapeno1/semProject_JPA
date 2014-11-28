package facades;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.UserDetails;

public class Facade implements facadeInterface {

    Map<Long, UserDetails> persons = new HashMap();
    private final Gson gson = new Gson();
    private static Facade instance = new Facade();
    UserDetails p = new UserDetails();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Persistance");
    EntityManager em = emf.createEntityManager();

    public static Facade getFacade(boolean reseet) {
        if (true) {
            instance = new Facade();
        }
        return instance;
    }

    public Facade() {
    }

    //Method to retrieve person based upon an ID.
    @Override
    public String getUserAsJson(String username) {
        UserDetails p = em.find(UserDetails.class, username);
        return gson.toJson(p);
    }

    //Adds a new person to the database.
    @Override
    public UserDetails addUserFromGson(String json) {
        em.getTransaction().begin();
        UserDetails p = gson.fromJson(json, UserDetails.class);
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    //Delete a person.
    @Override
    public UserDetails deleteUser(String userName) {
        em.getTransaction().begin();
        UserDetails p = em.find(UserDetails.class, userName);
        em.remove(p);
        em.getTransaction().commit();
        return p;
    }
}
