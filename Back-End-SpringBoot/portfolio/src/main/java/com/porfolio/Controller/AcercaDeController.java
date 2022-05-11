
package com.porfolio.Controller;

import com.porfolio.model.AcercaDe;
import com.porfolio.service.IAcercaDeService;
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
public class AcercaDeController {
    @Autowired
    private IAcercaDeService AceService;
    
    
    @GetMapping("/acercade")
    @ResponseBody
    public List<AcercaDe> obtenerAcercaDe(){
        return AceService.obtenerAcercaDe();      
    }
    
    @PostMapping("/acercade/crear")
    @ResponseBody
    public AcercaDe crearAcercaDe(@RequestBody AcercaDe acercaDe){
        return AceService.crearAcercaDe(acercaDe);
    }
    
    @DeleteMapping("/acercade/{id}")
    public void borrarAcercaDe(@PathVariable Long id){
        AceService.borrarAcercaDe(id);
    }
    
    @GetMapping("/acercade/{id}")
    @ResponseBody
    public AcercaDe obtenerAcercaDe(@PathVariable Long id){
        return AceService.obtenerAcercaDe(id);
    }
    
    @PutMapping("/acercade/update")
    public void modificarAcercaDe(@RequestBody AcercaDe acercaDe){
        System.out.println(acercaDe);
        AceService.modificarAcercaDe(acercaDe);
    }
    
}
