/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;


import com.porfolio.model.Aptitud;
import com.porfolio.repository.AptitudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptitudService implements IAptitudService{
   @Autowired 
    public AptitudRepository Aptrepo;

    @Override
    public List<Aptitud> obtenerAptitud() {
        return Aptrepo.findAll();
    }

    @Override
    public Aptitud crearAptitud(Aptitud aptitud) {
        return Aptrepo.save(aptitud);
    }

    @Override
    public void borrarAptitud(Long id) {
       Aptrepo.deleteById(id);
    }

    @Override
    public Aptitud obtenerAptitud(Long id) {
        return Aptrepo.findById(id).orElse(null);
    }

    @Override
    public void modificarAptitud(Aptitud aptitud) {
        Aptrepo.save(aptitud);
    }
    
}