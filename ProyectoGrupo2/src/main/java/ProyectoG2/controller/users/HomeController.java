package ProyectoG2.controller.users;

import ProyectoG2.domain.Usuario;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/home")
    public String mostrarHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        model.addAttribute("usuario", usuario);  

        return "private/home";  
    }
}