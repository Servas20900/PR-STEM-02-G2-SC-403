package ProyectoG2.controller.users;

import ProyectoG2.domain.Productos;
import ProyectoG2.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/productos")
    public String listarProductos(@RequestParam(value = "nombreArticulo", required = false) String nombreArticulo,
                                  @RequestParam(value = "marca", required = false) String marca,
                                  @RequestParam(value = "sexo", required = false) String sexo,
                                  @RequestParam(value = "talla", required = false) String talla,
                                  Model model) {

        List<Productos> productos = productosService.buscarPorFiltros(nombreArticulo, marca, sexo, talla);

        model.addAttribute("productos", productos);
        model.addAttribute("nombreArticulo", nombreArticulo);
        model.addAttribute("marca", marca);
        model.addAttribute("sexo", sexo);
        model.addAttribute("talla", talla);

        return "private/ServiciosAd/productos";
    }

    @GetMapping("/productos/detalle/{id}")
    public String detalleProducto(@PathVariable("id") Long id, Model model) {
        Productos producto = productosService.buscarPorId(id);
        if (producto == null) {
            return "redirect:/productos"; // Redirigir si no se encuentra el producto
        }
        model.addAttribute("producto", producto);
        return "private/ServiciosAd/detalle_producto";
    }
}
