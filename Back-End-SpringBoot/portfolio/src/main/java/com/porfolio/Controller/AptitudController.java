/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.Controller;

import com.porfolio.model.Aptitud;
import com.porfolio.service.IAptitudService;
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
public class AptitudController {
    @Autowired
    private IAptitudService AptService;
    
    
    @GetMapping("/aptitud")
    @ResponseBody
    public List<Aptitud> obtenerAptitud(){
        return AptService.obtenerAptitud();      
    }
    
    @PostMapping("/aptitud/crear")
    @ResponseBody
    public Aptitud crearAptitud(@RequestBody Aptitud aptitud){
        return AptService.crearAptitud(aptitud);
    }
    
    @DeleteMapping("/aptitud/{id}")
    public void borrarAptitud(@PathVariable Long id){
        AptService.borrarAptitud(id);
    }
    
    @GetMapping("/aptitud/{id}")
    @ResponseBody
    public Aptitud obtenerAptitud(@PathVariable Long id){
        return AptService.obtenerAptitud(id);
    }
    
    @PutMapping("/aptitud/update")
    public void modificarAptitud(@RequestBody Aptitud aptitud){
        System.out.println(aptitud);
        AptService.modificarAptitud(aptitud);
    }
    
}
