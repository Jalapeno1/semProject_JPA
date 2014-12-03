
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.UserDetails;

public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Persistance");
        EntityManager em = emf.createEntityManager();

        String username = "SOREN";

        UserDetails p = em.find(UserDetails.class, username);
        
        if(p==null){
            System.out.println("Error; no users with that username found.");
        } else {
            System.out.println("Password: " + p.getPassword());
            System.out.println("Person: " + p.getUsername());
            System.out.println("Auth: " + p.getAuthority());
            System.out.println(p);
        }
    }
}
