package ProyectoG2.controller.users;

import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.ClaseService;
import ProyectoG2.service.InscripcionService;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@RequestMapping("/clases")
@Controller
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    InscripcionService inscripcionService;

    @GetMapping("")
    public String listaClases(Model model) {
        var lista = claseService.getClases();
        model.addAttribute("clases", lista);

        return "private/clases/clases";
    }

    @PostMapping("/inscribir/{id}")
    public String inscribirse(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        Clase clase = claseService.getClaseById(id).get();

        boolean inscripcionExitosa = inscripcionService.crearInscripcion(usuario, clase);

        if (inscripcionExitosa) {
            claseService.actualizarInscripcion(id);
            redirectAttributes.addFlashAttribute("mensajeExito", "Inscripción exitosa en la clase.");
        }else{
            redirectAttributes.addFlashAttribute("mensajeError", "Ya estás inscrito en esta clase.");
        }

        return "redirect:/clases";
    }
}
