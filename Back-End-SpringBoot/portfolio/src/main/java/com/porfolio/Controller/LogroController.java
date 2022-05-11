/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.Controller;


import com.porfolio.model.Logro;
import com.porfolio.service.ILogroService;
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
public class LogroController {
    @Autowired
    private ILogroService LogService;
    
    
    @GetMapping("/logro")
    @ResponseBody
    public List<Logro> obtenerLogro(){
        return LogService.obtenerLogro();      
    }
    
    @PostMapping("/logro/crear")
    @ResponseBody
    public Logro crearLogro(@RequestBody Logro logro){
        return LogService.crearLogro(logro);
    }
    
    @DeleteMapping("/logro/{id}")
    public void borrarLogro(@PathVariable Long id){
        LogService.borrarLogro(id);
    }
    
    @GetMapping("/logro/{id}")
    @ResponseBody
    public Logro obtenerLogro(@PathVariable Long id){
        return LogService.obtenerLogro(id);
    }
    
    @PutMapping("/logro/update")
    public void modificarLogro(@RequestBody Logro logro){
        System.out.println(logro);
        LogService.modificarLogro(logro);
    }
    
}
