package ProyectoG2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicNavegationController {

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
