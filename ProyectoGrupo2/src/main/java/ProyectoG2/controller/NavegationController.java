package ProyectoG2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegationController {

    @GetMapping("/") // Página principal
    public String mostrarIndex() {
        return "public/index"; // Esto buscará index.html en templates/
    }

    @GetMapping("/sede") // Nueva ruta para vista.html
    public String mostrarSede() {
        return "public/sede"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/promociones") // Nueva ruta para vista.html
    public String mostrarPromociones() {
        return "public/promociones"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/contacto") // Nueva ruta para vista.html
    public String mostrarContacto() {
        return "public/contacto"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/home") // Nueva ruta para vista.html
    public String mostrarHome() {
        return "private/home"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/perfil") // Nueva ruta para vista.html
    public String mostrarPerfil() {
        return "private/perfil"; // Esto buscará vista.html en templates/
    }

    @GetMapping("/blog") // Nueva ruta para blogs.html
    public String mostrarBlogs() {
        return "private/blog"; // Buscará blogs.html en templates/
    }

    @GetMapping("/ServiciosAdicionales") // Nueva ruta para blogs.html
    public String mostrarServiciosAdicionales() {
        return "private/ServiciosAdicionales"; // Buscará blogs.html en templates/
    }

    @GetMapping("/ajustes")
    public String mostrarAjustes() {
        return "private/ajustes";
    }

    @GetMapping("/pago")
    public String mostrarPago() {
        return "private/pago";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "public/login";
    };

    @GetMapping("/singup")
    public String mostrarSingup() {
        return "public/singup";
    };
}
