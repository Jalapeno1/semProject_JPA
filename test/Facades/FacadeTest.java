/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import com.google.gson.Gson;
import facades.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import model.UserDetails;

/**
 *
 * @author Jonas
 */
public class FacadeTest extends TestCase
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Persistance");
    EntityManager em = emf.createEntityManager();
    
    private final Gson gson = new Gson();
    Facade facade = new Facade();
    
    public FacadeTest()
    {
    }

    /**
     * Test of getUserAsJson method, of class Facade.
     */
    public void testGetUserAsJson()
    {
        em.getTransaction().begin();
        String json = "{\"username\":\"HANSEN\",\"password\":\"TEST\",\"authority\":\"ADMIN\"}";
        
        UserDetails p = gson.fromJson(json, UserDetails.class);
        em.persist(p);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        
        String username = "HANSEN";
        UserDetails u = em.find(UserDetails.class, username);
        
        final String userAsJson = facade.getUserAsJson(username);
        
        assertEquals(true, userAsJson.contains(json));
    }

    /**
     * Test of addUserFromGson method, of class Facade.
     */
    public void testAddUserFromGson()
    {
        em.getTransaction().begin();
        String json = "{\"username\":\"JENSEN\",\"password\":\"TEST\",\"authority\":\"ADMIN\"}";
        
        UserDetails p = gson.fromJson(json, UserDetails.class);
        em.persist(p);
        em.getTransaction().commit();
    }

    /**
     * Test of deleteUser method, of class Facade.
     */
    public void testDeleteUser()
    {
        em.getTransaction().begin();
        String json = "{\"username\":\"MENSEN\",\"password\":\"TEST\",\"authority\":\"ADMIN\"}";
        
        UserDetails p = gson.fromJson(json, UserDetails.class);
        em.persist(p);
        em.getTransaction().commit();
        em.getTransaction().begin();
        
        String userName = "MENSEN";
        
        UserDetails c = em.find(UserDetails.class, userName);
        em.remove(c);
        em.getTransaction().commit();
    }
    
}
