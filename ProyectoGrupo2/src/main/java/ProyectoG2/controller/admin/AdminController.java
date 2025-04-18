package ProyectoG2.controller.admin;

import ProyectoG2.domain.Blog;
import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Tienda;
import ProyectoG2.service.BlogService;
import ProyectoG2.service.ClaseService;
import ProyectoG2.service.TiendaService;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

        System.out.println(productos);
        System.out.println(clases);
        System.out.println(blogs.size());

        model.addAttribute("total_productos", productos.size());
        model.addAttribute("total_clases", clases.size());
        model.addAttribute("total_blogs", blogs.size());
        //model.addAttribute("total_usuarios", usuarios.size());
        return "private/admin/home";
    }
}
