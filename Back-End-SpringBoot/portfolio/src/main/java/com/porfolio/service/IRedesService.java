/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;

import com.porfolio.model.Redes;
import java.util.List;


public interface IRedesService {
    public List<Redes> obtenerRedes();
    public Redes crearRedes(Redes redes);
    public void borrarRedes(Long id);
    public Redes obtenerRedes(Long id);
    public void modificarRedes(Redes redes);
}