/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Laczka Zoltan
 */
public class AdatbazisKapcsolat {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("egyseges");
    public static EntityManager em = emf.createEntityManager();
    
    /**
     * 
     * This is the EntityManager 
     */
    public static EntityManager getEntityManeger()
    {
        return em;
    }
    
    /**
     * close the entity
     */
    public static void close(){
    
        em.close();
        emf.close();
    }

}
