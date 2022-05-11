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
public class Experiencia{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String company;
    private String position;
    private Date fecha_start;
    private Date fecha_end;
    private String img;

    public Experiencia() {
    }

    public Experiencia(long id, String company, String position, Date fecha_start, Date fecha_end, String img) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.fecha_start = fecha_start;
        this.fecha_end = fecha_end;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + ", company=" + company + ", position=" + position + ", fecha_start=" + fecha_start + ", fecha_end=" + fecha_end + ", img=" + img + '}';
    }

    
    
}
