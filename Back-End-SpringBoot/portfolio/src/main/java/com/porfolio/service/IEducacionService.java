
package com.porfolio.service;

import com.porfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> obtenerEduacion();
    public Educacion crearEducacion(Educacion educacion);
    public void borrarEducacion(Long id);
    public Educacion obtenerEducacion(Long id);
    public void modificarEducacion(Educacion educacion);
}
