
package com.porfolio.service;


import com.porfolio.model.AcercaDe;
import com.porfolio.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDeService{
   @Autowired 
    public AcercaDeRepository Acerepo;

    @Override
    public List<AcercaDe> obtenerAcercaDe() {
        return Acerepo.findAll();
    }

    @Override
    public AcercaDe crearAcercaDe(AcercaDe acercaDe) {
        return Acerepo.save(acercaDe);
    }

    @Override
    public void borrarAcercaDe(Long id) {
       Acerepo.deleteById(id);
    }

    @Override
    public AcercaDe obtenerAcercaDe(Long id) {
        return Acerepo.findById(id).orElse(null);
    }

    @Override
    public void modificarAcercaDe(AcercaDe acercaDe) {
        Acerepo.save(acercaDe);
    }
    
}