package com.EscuelaU.API_SitioU.Controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EscuelaU.API_SitioU.Models.Usuario;
import com.EscuelaU.API_SitioU.Models.UsuarioDAO;

@CrossOrigin
@RestController
public class MainController {

    private UsuarioDAO usuarioDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MainController(UsuarioDAO usuarioDAO,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioDAO = usuarioDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/registrarse")
    public void signUp(@RequestBody Usuario usuario) {
    	usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuarioDAO.save(usuario);
    }
}