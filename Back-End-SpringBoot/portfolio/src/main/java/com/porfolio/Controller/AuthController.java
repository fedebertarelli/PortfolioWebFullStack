
package com.porfolio.Controller;


import com.porfolio.model.dto.UserDto;
import com.porfolio.model.Usuario;
import com.porfolio.service.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService servicio;
    
   @PostMapping("/login")
    public boolean login(@RequestBody UserDto userDto){
        
        return servicio.isUserEnabled(userDto);
    }
    
    @PostMapping("/register")
    public void register(@RequestBody Usuario usuario) throws Exception{
        
        servicio.crearUsuario(usuario);
    }
    
    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(@PathVariable Long id){
        return servicio.obtenerUsuario(id);
    }
    
    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> obtenerUsuario(){
        return servicio.obtenerEduacion();      
    }
}
