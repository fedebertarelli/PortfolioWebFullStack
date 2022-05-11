
package com.porfolio.Controller;

import com.porfolio.model.Educacion;
import com.porfolio.service.IEducacionService;
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
public class EducacionController {
    @Autowired
    private IEducacionService EduService;
    
    
    @GetMapping("/educacion")
    @ResponseBody
    public List<Educacion> obtenerEducacion(){
        return EduService.obtenerEduacion();      
    }
    
    @PostMapping("/educacion/crear")
    @ResponseBody
    public Educacion crearEducacion(@RequestBody Educacion educacion){
        return EduService.crearEducacion(educacion);
    }
    
    @DeleteMapping("/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id){
        EduService.borrarEducacion(id);
    }
    
    @GetMapping("/educacion/{id}")
    @ResponseBody
    public Educacion obtenerEducacion(@PathVariable Long id){
        return EduService.obtenerEducacion(id);
    }
    
    @PutMapping("/educacion/update")
    public void modificarEduacion(@RequestBody Educacion educacion){
        System.out.println(educacion);
        EduService.modificarEducacion(educacion);
    }
    
}
