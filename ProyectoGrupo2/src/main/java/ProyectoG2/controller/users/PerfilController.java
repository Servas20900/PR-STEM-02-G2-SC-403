package ProyectoG2.controller.users;


import ProyectoG2.domain.Usuario;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/listado")
    public String mostrarListadoPerfil(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
    
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
    
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "private/perfil/listado"; 
        } else {
            return "redirect:/login?error"; 
        }
    }
 
    @GetMapping("/editar/{idUsuario}")
    public String editarUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "private/perfil/formulario"; 
        } else {
            return "redirect:/perfil/listado";
        }
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save1(usuario);
        return "redirect:/perfil/listado";
    }




}
