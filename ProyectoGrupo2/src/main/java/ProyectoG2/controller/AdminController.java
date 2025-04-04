package ProyectoG2.controller;

import ProyectoG2.domain.Blog;
import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Tienda;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.BlogService;
import ProyectoG2.service.ClaseService;
import ProyectoG2.service.TiendaService;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TiendaService tiendaService;

    @Autowired
    private ClaseService claseService;

    @Autowired
    BlogService blogService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String homeAdmin(Model model) {
        List<Tienda> productos = tiendaService.listarProductos();
        List<Clase> clases = claseService.getClases();
        List<Blog> blogs = blogService.getAllBlogs();
        //List<Usuario> usuarios = usuarioService.getUsuarios();

        model.addAttribute("total_productos", productos.size());
        model.addAttribute("total_clases", clases.size());
        model.addAttribute("total_blogs", blogs.size());
        //model.addAttribute("total_usuarios", usuarios.size());
        return "private/admin/home";
    }

    ;

    @GetMapping("productos")
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

    @GetMapping("clases")
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
        return "private/admin/clases/lista";
    }
}
