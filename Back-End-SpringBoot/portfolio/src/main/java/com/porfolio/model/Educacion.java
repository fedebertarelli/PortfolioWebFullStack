
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String school;
    private String title;
    private Date fecha_start;
    private Date fecha_end;
    private String img;

    public Educacion() {
    }

    public Educacion(long id, String school, String title, Date fecha_start, Date fecha_end, String img) {
        this.id = id;
        this.school = school;
        this.title = title;
        this.fecha_start = fecha_start;
        this.fecha_end = fecha_end;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Educacion{" + "id=" + id + ", school=" + school + ", title=" + title + ", fecha_start=" + fecha_start + ", fecha_end=" + fecha_end + ", img=" + img + '}';
    }


    
}
