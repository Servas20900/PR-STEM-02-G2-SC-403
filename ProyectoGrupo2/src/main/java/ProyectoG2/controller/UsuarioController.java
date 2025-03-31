package ProyectoG2.controller;

import ProyectoG2.domain.Usuario;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/perfil")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = usuarioService.getUsuario(1L); // Aquí puedes cambiar para obtener el usuario logueado
        model.addAttribute("usuario", usuario);
        return "perfil/perfil"; // Carga la vista con los datos del usuario
    }

    // Obtener la lista de usuarios
    @GetMapping("/listado")
    public String getUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "private/perfil/listado"; // Carga el archivo listado.html dentro de templates/perfil/
    }

    // Mostrar el formulario para agregar o modificar un usuario
    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/perfil/modifica"; // Carga el formulario de creación o edición
    }

    // Guardar un usuario (ya sea nuevo o actualizado)
    @PostMapping("/guardar")
    public String saveUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/perfil/listado"; // Redirige a la lista de usuarios
    }

    // Obtener un usuario específico por ID
    @GetMapping("/{id}")
    public String getUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuario(id);
        model.addAttribute("usuario", usuario);
        return "perfil/perfil"; // Carga la vista con los datos del usuario
    }
}
