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
public class Encabezado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic
    private String backImage;
    private String imgCV;
    private String name;
    private String position;
    private String ubication;
    private String imgCompany;
    private String nameCompany;
    private String imgSchool;
    private String nameSchool;
 

    public Encabezado() {
    }

    public Encabezado(long id, String backImage, String imgCV, String name, String position, String ubication, String imgCompany, String nameCompany, String imgSchool, String nameSchool) {
        this.id = id;
        this.backImage = backImage;
        this.imgCV = imgCV;
        this.name = name;
        this.position = position;
        this.ubication = ubication;
        this.imgCompany = imgCompany;
        this.nameCompany = nameCompany;
        this.imgSchool = imgSchool;
        this.nameSchool = nameSchool;
    }

    @Override
    public String toString() {
        return "Encabezado{" + "id=" + id + ", backImage=" + backImage + ", imgCV=" + imgCV + ", name=" + name + ", position=" + position + ", ubication=" + ubication + ", imgCompany=" + imgCompany + ", nameCompany=" + nameCompany + ", imgSchool=" + imgSchool + ", nameSchool=" + nameSchool + '}';
    }

   


    
}
