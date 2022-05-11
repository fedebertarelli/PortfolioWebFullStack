/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.Controller;


import com.porfolio.model.Redes;
import com.porfolio.service.IRedesService;
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
public class RedesController {
    @Autowired
    private IRedesService redService;
    
    @GetMapping("/redes")
    @ResponseBody
    public List<Redes> obtenerRedes(){
        return redService.obtenerRedes();      
    }
    
    @PostMapping("/redes/crear")
    @ResponseBody
    public Redes crearRedes(@RequestBody Redes redes){
        return redService.crearRedes(redes);
    }
    
    @DeleteMapping("/redes/{id}")
    public void borrarRedes(@PathVariable Long id){
        redService.borrarRedes(id);
    }
    
    @GetMapping("/redes/{id}")
    @ResponseBody
    public Redes obtenerRedes(@PathVariable Long id){
        return redService.obtenerRedes(id);
    }
    
    @PutMapping("/redes/update")
    public void modificarRedes(@RequestBody Redes redes){
        System.out.println(redes);
        redService.modificarRedes(redes);
    }
}
