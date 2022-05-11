/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;


import com.porfolio.model.Aptitud;
import java.util.List;


public interface IAptitudService {
    public List<Aptitud> obtenerAptitud();
    public Aptitud crearAptitud(Aptitud aptitud);
    public void borrarAptitud(Long id);
    public Aptitud obtenerAptitud(Long id);
    public void modificarAptitud(Aptitud aptitud);
}
