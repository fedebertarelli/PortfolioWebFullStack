
package com.porfolio.service;

import com.porfolio.model.dto.UserDto;
import com.porfolio.model.Usuario;
import com.porfolio.repository.AuthRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
@Autowired
    AuthRepository repository;
    
@Autowired
    PasswordEncoder passwordEncoder;
    
    public boolean isUserEnabled(UserDto userDto) {
        boolean isUserEnabled = false;
        List<Usuario> usuarios = repository.findByEmailAndIsEnabledTrue(userDto.getEmail());
        if (!usuarios.isEmpty()) {
            Usuario usuario = usuarios.get(0);
            if (passwordEncoder.matches(userDto.getPassword(), usuario.getPassword()))
                isUserEnabled = true;
        }
        return isUserEnabled;
    }
    
    public void crearUsuario(Usuario usuario) throws Exception{
        List<Usuario> usuarios = repository.findByEmailAndIsEnabledTrue(usuario.getEmail());
        if (!usuarios.isEmpty()) {
            throw new Exception("El email ya está registrado.");
        } else {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuario.setEnabled(true);
            repository.save(usuario);
        }
    }
    
     public Usuario obtenerUsuario(Long id) {
        return repository.findById(id).orElse(null);
    }
     
      public List<Usuario> obtenerEduacion() {
        return repository.findAll();
    } 
        
}
