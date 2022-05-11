
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
public class Logro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String name;
    private String descripcion;
   

    public Logro() {
    }

    @Override
    public String toString() {
        return "Logro{" + "id=" + id + ", name=" + name + ", descripcion=" + descripcion + '}';
    }

    public Logro(long id, String name, String descripcion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }




    
}
