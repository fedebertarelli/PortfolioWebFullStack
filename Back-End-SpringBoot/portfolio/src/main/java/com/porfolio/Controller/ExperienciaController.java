/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.Controller;


import com.porfolio.model.Experiencia;
import com.porfolio.service.IExperienciaService;
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
public class ExperienciaController {
    @Autowired
    private IExperienciaService ExpService;
    
    
    @GetMapping("/experiencia")
    @ResponseBody
    public List<Experiencia> obtenerExperiencia(){
        return ExpService.obtenerExperiencia();      
    }
    
    @PostMapping("/experiencia/crear")
    @ResponseBody
    public Experiencia crearExperiencia(@RequestBody Experiencia experiencia){
        return ExpService.crearExperiencia(experiencia);
    }
    
    @DeleteMapping("/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        ExpService.borrarExperiencia(id);
    }
    
    @GetMapping("/experiencia/{id}")
    @ResponseBody
    public Experiencia obtenerExperiencia(@PathVariable Long id){
        return ExpService.obtenerExperiencia(id);
    }
    
    @PutMapping("/experiencia/update")
    public void modificarExperiencia(@RequestBody Experiencia experiencia){
        System.out.println(experiencia);
        ExpService.modificarExperiencia(experiencia);
    }
    
}
