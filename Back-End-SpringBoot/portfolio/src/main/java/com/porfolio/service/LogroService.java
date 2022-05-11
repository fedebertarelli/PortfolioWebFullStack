/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;


import com.porfolio.model.Logro;
import com.porfolio.repository.LogroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogroService implements ILogroService{
   @Autowired 
    public LogroRepository Logrepo;

    @Override
    public List<Logro> obtenerLogro() {
        return Logrepo.findAll();
    }

    @Override
    public Logro crearLogro(Logro logro) {
        return Logrepo.save(logro);
    }

    @Override
    public void borrarLogro(Long id) {
       Logrepo.deleteById(id);
    }

    @Override
    public Logro obtenerLogro(Long id) {
        return Logrepo.findById(id).orElse(null);
    }

    @Override
    public void modificarLogro(Logro logro) {
        Logrepo.save(logro);
    }
    
}
