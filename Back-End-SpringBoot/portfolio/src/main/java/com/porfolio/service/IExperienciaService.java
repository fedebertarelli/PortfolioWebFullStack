/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;

import com.porfolio.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> obtenerExperiencia();
    public Experiencia crearExperiencia(Experiencia experiencia);
    public void borrarExperiencia(Long id);
    public Experiencia obtenerExperiencia(Long id);
    public void modificarExperiencia(Experiencia experiencia);
}
