package ProyectoG2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ProyectoG2.domain.Usuario;
import ProyectoG2.domain.Rol;
import ProyectoG2.service.UsuarioService;
import ProyectoG2.service.RolService;

import java.util.Collections;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "public/registro"; 
    }

    
    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    
        Rol rolUser = rolService.getRoles().stream()
            .filter(r -> r.getNombre().equals("ROLE_USER"))
            .findFirst()
            .orElseGet(() -> {
                Rol nuevo = new Rol();
                nuevo.setNombre("ROLE_USER");
                rolService.save(nuevo);
                return nuevo;
            });
    
        usuario.setRoles(Collections.singletonList(rolUser));
        
        usuarioService.save(usuario);
    
        return "redirect:/login";
    }
    
}
