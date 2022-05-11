
package com.porfolio.service;

import com.porfolio.model.Educacion;
import com.porfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
   @Autowired 
    public EducacionRepository Edurepo;

    @Override
    public List<Educacion> obtenerEduacion() {
        return Edurepo.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educacion) {
        return Edurepo.save(educacion);
    }

    @Override
    public void borrarEducacion(Long id) {
       Edurepo.deleteById(id);
    }

    @Override
    public Educacion obtenerEducacion(Long id) {
        return Edurepo.findById(id).orElse(null);
    }

    @Override
    public void modificarEducacion(Educacion educacion) {
        Edurepo.save(educacion);
    }
    
}
