/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;

import com.porfolio.model.Logro;
import java.util.List;


public interface ILogroService {
    public List<Logro> obtenerLogro();
    public Logro crearLogro(Logro logro);
    public void borrarLogro(Long id);
    public Logro obtenerLogro(Long id);
    public void modificarLogro(Logro Logro);
}