/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;

import com.porfolio.model.Redes;
import com.porfolio.repository.RedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesService implements IRedesService {
    
    @Autowired 
    public RedesRepository Redrepo;

    @Override
    public List<Redes> obtenerRedes() {
         return Redrepo.findAll();
    }

    @Override
    public Redes crearRedes(Redes redes) {
        return Redrepo.save(redes);
    }

    @Override
    public void borrarRedes(Long id) {
        Redrepo.deleteById(id);
    }

    @Override
    public Redes obtenerRedes(Long id) {
        return Redrepo.findById(id).orElse(null);
    }

    @Override
    public void modificarRedes(Redes redes) {
        Redrepo.save(redes);
    }
    
}
