
package com.porfolio.service;


import com.porfolio.model.AcercaDe;
import java.util.List;


public interface IAcercaDeService {
    public List<AcercaDe> obtenerAcercaDe();
    public AcercaDe crearAcercaDe(AcercaDe acercaDe);
    public void borrarAcercaDe(Long id);
    public AcercaDe obtenerAcercaDe(Long id);
    public void modificarAcercaDe(AcercaDe acercaDe);
}