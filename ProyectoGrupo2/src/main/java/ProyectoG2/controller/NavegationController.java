package ProyectoG2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavegationController {
   
   @GetMapping("/")  // Página principal
   public String mostrarIndex() {
       return "index"; // Esto buscará index.html en templates/
   }

   @GetMapping("/sede") // Nueva ruta para vista.html
   public String mostrarVista() {
       return "sede"; // Esto buscará vista.html en templates/
   }





   
}
