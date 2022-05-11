/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Redes{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String nombre;
    private String facebook;
    private String instagram;
    private String twitter;

    public Redes() {
    }

    public Redes(long id, String nombre, String facebook, String instagram, String twitter) {
        this.id = id;
        this.nombre = nombre;
        this.facebook = facebook;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "Redes{" + "id=" + id + ", nombre=" + nombre + ", facebook=" + facebook + ", instagram=" + instagram + ", twitter=" + twitter + '}';
    }
    
    
    
}
    

