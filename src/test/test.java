/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.UserDetails;

/**
 *
 * @author frederikolesen
 */
public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Persistance");
        EntityManager em = emf.createEntityManager();

        String username = "JONAS";

        UserDetails p = em.find(UserDetails.class, username);
        //System.out.println("Password: " + p.getPassword());

        System.out.println("Person: " + p);
    }
}
