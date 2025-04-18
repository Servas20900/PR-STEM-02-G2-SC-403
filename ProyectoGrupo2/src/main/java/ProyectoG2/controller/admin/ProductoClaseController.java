package ProyectoG2.controller.admin;


import ProyectoG2.domain.Tienda;
import ProyectoG2.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/productos")
public class ProductoClaseController {

    @Autowired
    TiendaService tiendaService;

    @GetMapping("")
    public String getListaProductos(Model model) {
        List<Tienda> productos = tiendaService.listarProductos();

        List<List<String>> items = new ArrayList<>();

        for (Tienda producto : productos) {
            List<String> item = new ArrayList<>();
            item.add(Integer.toString(
                    producto.getIdArticulo().intValue()
            ));
            item.add(producto.getNombreArticulo());
            item.add(Double.toString(
                    producto.getPrecio()
            ));
            item.add(producto.getMarca());
            item.add(producto.getCategoria());
            items.add(item);
        }

        model.addAttribute("productos", items);
        model.addAttribute("total_productos", productos.size());
        return "private/admin/productos/lista";
    }
}
