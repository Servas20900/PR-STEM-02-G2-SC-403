package ProyectoG2.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateNavigationController {


    @GetMapping("/ajustes")
    public String mostrarAjustes() {
        return "private/ajustes";
    }
}
