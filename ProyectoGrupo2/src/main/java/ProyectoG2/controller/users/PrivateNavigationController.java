package ProyectoG2.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateNavigationController {
    @GetMapping("/home") // Nueva ruta para vista.html
    public String mostrarHome() {
        return "private/home"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/perfil") // Nueva ruta para vista.html
    public String mostrarPerfil() {
        return "private/perfil/listado"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/blog") // Nueva ruta para blogs.html
    public String mostrarBlogs() {
        return "private/blog"; // Buscará blogs.html en templates/
    }



    @GetMapping("/ajustes")
    public String mostrarAjustes() {
        return "private/ajustes";
    }
}
