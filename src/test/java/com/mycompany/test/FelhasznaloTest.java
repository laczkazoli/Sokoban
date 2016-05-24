package com.mycompany.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.db.Felhasznalo;
import com.mycompany.db.AdatbazisKapcsolat;
import com.mycompany.db.FelhasznaloDAO;

public class FelhasznaloTest {

    private static AdatbazisKapcsolat es = new AdatbazisKapcsolat();

    @Test
    public void beallitja() {
        Felhasznalo a = new Felhasznalo();
        a.setId(1);
        a.setFelhasznalonev("felhasznalonev");
        a.setPontszam("öt");
    }

    @Test
    public void visszaAdja() {
        Felhasznalo a = new Felhasznalo();
        a.setId(null);
        a.setFelhasznalonev("felhasznalonev");
        a.setPontszam("öt");

        assertEquals("felhasznalonev", a.getFelhasznalonev());
        assertEquals("öt", a.getPontszam());

    }

    @BeforeClass
    public static void sqlBeallitas() throws Exception {
        AdatbazisKapcsolat.em = (EntityManager) Persistence.createEntityManagerFactory("egyseges").createEntityManager();
    }

    @Test
    public void adazbazisMuveletek() {

        Felhasznalo b = new Felhasznalo();
        b.setFelhasznalonev("Felhasznalo");
        b.setPontszam("pontszam");

        AdatbazisKapcsolat.em.persist(b);
        AdatbazisKapcsolat.em.remove(b);
    }
    
    
    


}
