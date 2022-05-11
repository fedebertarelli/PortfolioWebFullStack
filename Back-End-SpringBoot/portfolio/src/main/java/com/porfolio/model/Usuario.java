
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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String nombre;
    private String email;
    private String password;
    private boolean isEnabled;
    private boolean editor;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String email, String password, boolean isEnabled, boolean editor) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", isEnabled=" + isEnabled + ", isEditor=" + editor + '}';
    }


    
    
}