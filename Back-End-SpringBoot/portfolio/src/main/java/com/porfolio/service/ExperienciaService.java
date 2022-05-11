/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;


import com.porfolio.model.Experiencia;
import com.porfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
   @Autowired 
    public ExperienciaRepository Exprepo;

    @Override
    public List<Experiencia> obtenerExperiencia() {
        return Exprepo.findAll();
    }

    @Override
    public Experiencia crearExperiencia(Experiencia experiencia) {
        return Exprepo.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
       Exprepo.deleteById(id);
    }

    @Override
    public Experiencia obtenerExperiencia(Long id) {
        return Exprepo.findById(id).orElse(null);
    }

    @Override
    public void modificarExperiencia(Experiencia experiencia) {
        Exprepo.save(experiencia);
    }
    
}