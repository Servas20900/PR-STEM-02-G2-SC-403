package ProyectoG2.controller.admin;


import ProyectoG2.domain.Productos;
import ProyectoG2.domain.Tienda;
import ProyectoG2.service.ProductosService;
import ProyectoG2.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/productos")
public class ProductoClaseController {

    @Autowired
    TiendaService tiendaService;

    @Autowired
    ProductosService productosService;

    @GetMapping("")
    public String getListaProductos(Model model) {
        List<Productos> productos = productosService.listarProductos();

        List<List<String>> items = new ArrayList<>();

        for (Productos producto : productos) {
            List<String> item = new ArrayList<>();
            item.add(Long.toString(
                    producto.getId_articulo()
            ));
            item.add(producto.getNombreArticulo());
            item.add(Double.toString(
                    producto.getPrecio()
            ));
            item.add(producto.getMarca());
            item.add(producto.getSexo());
            items.add(item);
        }

        model.addAttribute("productos", items);
        model.addAttribute("total_productos", productos.size());
        return "/private/admin/productos/lista_productos";
    }

    @GetMapping("/nuevo")
    public String getNuevoProducto(Model model) {
        model.addAttribute("producto", new Tienda());
        return "/private/admin/productos/producto_form";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable long id, Model model) {
        model.addAttribute("producto", tiendaService.obtenerProductoPorId(id));

        return "private/admin/productos/producto_form";
    }

    @PostMapping("/guardar")
    public String guardarProducto(Tienda tienda) {
        tiendaService.guardar(tienda);

        return "redirect:/admin/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable long id) {
        tiendaService.eliminar(id);

        return "redirect:/admin/productos";
    }
}
