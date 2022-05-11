/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.Controller;

import com.porfolio.model.Encabezado;
import com.porfolio.service.IEncabezadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncabezadoController {
    @Autowired
    private IEncabezadoService EncService;
    
    
    @GetMapping("/encabezado")
    @ResponseBody
    public List<Encabezado> obtenerEncabezado(){
        return EncService.obtenerEncabezado();      
    }
    
    @PostMapping("/encabezado/crear")
    @ResponseBody
    public Encabezado crearEncabezado(@RequestBody Encabezado encabezado){
        return EncService.crearEncabezado(encabezado);
    }
    
    @DeleteMapping("/encabezado/{id}")
    public void borrarEncabezado(@PathVariable Long id){
        EncService.borrarEncabezado(id);
    }
    
    @GetMapping("/encabezado/{id}")
    @ResponseBody
    public Encabezado obtenerEncabezado(@PathVariable Long id){
        return EncService.obtenerEncabezado(id);
    }
    
    @PutMapping("/encabezado/update")
    public void modificarEncabezado(@RequestBody Encabezado encabezado){
        System.out.println(encabezado);
        EncService.modificarEncabezado(encabezado);
    }
    
}
