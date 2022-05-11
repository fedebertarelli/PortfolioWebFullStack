
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
public class AcercaDe{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String about;

    public AcercaDe() {
    }

    public AcercaDe(long id, String about) {
        this.id = id;
        this.about = about;
    }

    @Override
    public String toString() {
        return "AcercaDe{" + "id=" + id + ", about=" + about + '}';
    }
  




    
}