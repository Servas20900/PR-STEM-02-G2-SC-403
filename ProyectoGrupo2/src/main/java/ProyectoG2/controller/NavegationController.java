package ProyectoG2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {

    @GetMapping("/") // Página principal
    public String mostrarIndex() {
        return "index"; // Esto buscará index.html en templates/
    }

    @GetMapping("/sede") // Nueva ruta para vista.html
    public String mostrarSede() {
        return "sede"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/promociones") // Nueva ruta para vista.html
    public String mostrarPromociones() {
        return "promociones"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/contacto") // Nueva ruta para vista.html
    public String mostrarContacto() {
        return "contacto"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/home") // Nueva ruta para vista.html
    public String mostrarHome() {
        return "home"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/perfil") // Nueva ruta para vista.html
    public String mostrarPerfil() {
        return "perfil"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/blog") // Nueva ruta para blogs.html
    public String mostrarBlogs() {
        return "blog"; // Buscará blogs.html en templates/
    }
}
