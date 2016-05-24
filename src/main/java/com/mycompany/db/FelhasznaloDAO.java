/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Laczka Zoltan
 */
public class FelhasznaloDAO {
    
    
    public static void felhasznaloHozzaad(String nev, String pont){
           
        Felhasznalo felh=new Felhasznalo(null,nev,pont);
        
        EntityManager em = AdatbazisKapcsolat.getEntityManeger();
        em.getTransaction().begin();
        em.persist(felh);
        em.getTransaction().commit();
        
    }
    
    public static List<Felhasznalo> lekerfelhasznalo(){
        
        EntityManager em = AdatbazisKapcsolat.getEntityManeger();
        TypedQuery<Felhasznalo> query=em.createQuery("SELECT f from Felhasznalo f",Felhasznalo.class);
        return query.getResultList();
        
    }
}
