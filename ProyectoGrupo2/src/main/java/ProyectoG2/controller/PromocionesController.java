package ProyectoG2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ProyectoG2.domain.Promociones;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.PromocionesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/promociones")
public class PromocionesController {

    @Autowired
    private PromocionesService promocionesService;

    // @GetMapping("/promociones")
    // public String promociones(Model model) {
    // Promociones promocion = promocionesService.getPromociones(1);
    // model.addAttribute("promocion", promocion);
    // return "public/promociones/listado";
    // }

    @GetMapping("/promociones")
    public String getPromociones(Model model) {
        List<Promociones> promocion = promocionesService.getPromociones();
        model.addAttribute("promocion", promocion);
        model.addAttribute("totalPromociones", promocion.size());
        return "public/promociones/listado";
    }

    @GetMapping("/nuevo")
    public String promocionNueva(Usuario usuario) {
        return "/promociones/modifica"; // Carga el formulario de creación o edición
    }

    @GetMapping("/listado")
    public String saveUsuario(@ModelAttribute Promociones promocion) {
        promocionesService.save(promocion);
        return "/promociones/listado"; // Redirige a la lista de usuarios
    }

}
