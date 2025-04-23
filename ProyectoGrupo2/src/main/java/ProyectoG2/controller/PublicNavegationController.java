package ProyectoG2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicNavegationController {

    @GetMapping("/") 
    public String mostrarIndex() {
        return "public/index"; 
    }

    @GetMapping("/sede") 
    public String mostrarSede() {
        return "public/sede"; 
    }


    @GetMapping("/promociones") 
    public String mostrarPromociones() {
        return "public/promociones"; 
    }

    @GetMapping("/contacto") 
    public String mostrarContacto() {
        return "public/contacto"; 
    }

    @GetMapping("/pago")
    public String mostrarPago() {
        return "private/pago";
    }



}
