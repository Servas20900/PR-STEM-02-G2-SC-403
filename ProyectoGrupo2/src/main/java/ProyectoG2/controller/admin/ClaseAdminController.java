package ProyectoG2.controller.admin;


import ProyectoG2.domain.Clase;
import ProyectoG2.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/clases")
public class ClaseAdminController {

    @Autowired
    ClaseService claseService;

    @GetMapping("")
    public String getListaClases(Model model) {
        List<Clase> clases = claseService.getClases();

        List<List<String>> items = new ArrayList<>();

        for (Clase clase : clases) {
            List<String> item = new ArrayList<>();
            item.add(Integer.toString(
                    clase.getIdClase()
            ));
            item.add(clase.getNombre_clase());
            item.add(clase.getTipo());
            item.add(clase.getDificultad());
            item.add(clase.getInstructor());
            items.add(item);
        }

        model.addAttribute("clases", items);
        model.addAttribute("total_clases", clases.size());
        return "/private/admin/clases/lista_clases";
    }

    @GetMapping("/nueva")
    public String nuevaClase(Model model) {
        model.addAttribute("clase", new Clase());
        return "/private/admin/clases/clase_form";
    }

    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable int id, Model model) {
        Optional<Clase> clase = claseService.getClaseById(id);
        model.addAttribute("clase", clase.get());
        return "private/admin/clases/clase_form";
    }

    @PostMapping("/guardar")
    public String guardarClase(@ModelAttribute Clase clase) {
        claseService.save(clase);

        return "redirect:/admin/clases";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable int id) {
        claseService.deleteById(id);
        return "redirect:/admin/clases";
    }


}
