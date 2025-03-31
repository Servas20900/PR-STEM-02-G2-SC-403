package ProyectoG2.controller;

import ProyectoG2.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping("/clases")
    public String listaClases(Model model){
        var lista = claseService.getClases();
        model.addAttribute("clases", lista);
        return "private/clases/clases";
    }
}
