/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.model;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Aptitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String name;
    private Number progress;
   

    public Aptitud() {
    }

    public Aptitud(long id, String name, Number progress) {
        this.id = id;
        this.name = name;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Aptitud{" + "id=" + id + ", name=" + name + ", progress=" + progress + '}';
    }



    
}
