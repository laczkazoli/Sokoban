/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laczka Zoltan
 */

@Entity
@Table(name = "prt")
public class Felhasznalo {
    

	@Id
	@Column(name = "id")
        @SequenceGenerator(name ="IDgenerator", sequenceName="felhasznalo_id_s", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "IDgenerator")
	private Integer id;

        
       
	@Column(name = "felhasznalo")
	private String felhasznalonev;
        
	@Column(name = "eredmeny")
	private String pontszam;
        
        
    public Felhasznalo(Integer id, String felhasznalonev, String pontszam) {
        this.id = id;
        this.felhasznalonev = felhasznalonev;
        this.pontszam = pontszam;
    }

	public Felhasznalo() {
		
	}
	
    public Integer getId() {
        return id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public String getPontszam() {
        return pontszam;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setPontszam(String pontszam) {
        this.pontszam = pontszam;
    }
        
    @Override
    public String toString()
    {
    return felhasznalonev+" "+pontszam;
    }
        
    
}