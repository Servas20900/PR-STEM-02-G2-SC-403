package ProyectoG2.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateNavigationController {


    @GetMapping("/perfil") 
    public String mostrarPerfil() {
        return "private/perfil/listado"; 
    }

    @GetMapping("/blog") 
    public String mostrarBlogs() {
        return "private/blog"; 
    }



    @GetMapping("/ajustes")
    public String mostrarAjustes() {
        return "private/ajustes";
    }
}
