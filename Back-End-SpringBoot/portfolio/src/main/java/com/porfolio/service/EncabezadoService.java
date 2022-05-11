/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;


import com.porfolio.model.Encabezado;
import com.porfolio.repository.EncabezadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncabezadoService implements IEncabezadoService{
   @Autowired 
    public EncabezadoRepository Encrepo;

    @Override
    public List<Encabezado> obtenerEncabezado() {
        return Encrepo.findAll();
    }

    @Override
    public Encabezado crearEncabezado(Encabezado encabezado) {
        return Encrepo.save(encabezado);
    }

    @Override
    public void borrarEncabezado(Long id) {
       Encrepo.deleteById(id);
    }

    @Override
    public Encabezado obtenerEncabezado(Long id) {
        return Encrepo.findById(id).orElse(null);
    }

    @Override
    public void modificarEncabezado(Encabezado encabezado) {
        Encrepo.save(encabezado);
    }
    
}