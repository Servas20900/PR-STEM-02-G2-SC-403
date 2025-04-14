package ProyectoG2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ProyectoG2.domain.Tienda;
import ProyectoG2.service.TiendaService;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TiendaController {

    @Autowired
    private TiendaService tiendaService; 
    

    @GetMapping("/tienda")
    public String listarProductos(Model model) {
        model.addAttribute("productos", tiendaService.listarProductos());
        return "private/ServiciosAd/tienda";
    }


   

    @GetMapping("/tienda/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Tienda producto = tiendaService.obtenerProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "private/ServiciosAd/detalleProducto";
        }
        return "redirect:/tienda";
    }

    @PostMapping("/tienda/guardar")
    public String guardarProducto(Tienda tienda) {
        tiendaService.guardar(tienda);
        return "redirect:/tienda";
    }

    @GetMapping("/tienda/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        tiendaService.eliminar(id);
        return "redirect:/tienda";
    }
}