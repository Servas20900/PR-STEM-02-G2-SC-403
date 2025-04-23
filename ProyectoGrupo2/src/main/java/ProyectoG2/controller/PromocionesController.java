package ProyectoG2.controller;

import ProyectoG2.domain.Promociones;
import ProyectoG2.service.PromocionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/promociones")
public class PromocionesController {

    @Autowired
    private PromocionesService promocionesService;

    @GetMapping("/listado")
    public String listarPromociones(Model model) {
        List<Promociones> promociones = promocionesService.getPromociones();
        model.addAttribute("promocioness", promociones);
        model.addAttribute("totalPromociones", promociones.size());
        return "public/promocionesF/listado";
    }
}
