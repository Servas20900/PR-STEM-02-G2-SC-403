package ProyectoG2.controller.admin;


import ProyectoG2.domain.Blog;
import ProyectoG2.domain.Clase;
import ProyectoG2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/blogs")
public class BlogAdminController {

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public String getListaClases(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();

        List<List<String>> items = new ArrayList<>();

        for (Blog blog : blogs) {
            List<String> item = new ArrayList<>();
            item.add(Integer.toString(
                    blog.getId_articulo_blog().intValue()
            ));
            item.add(blog.getTitulo());
            item.add(blog.getCategoria());
            items.add(item);
        }

        model.addAttribute("blogs", items);
        model.addAttribute("total_blogs", blogs.size());
        return "/private/admin/blogs/lista_blogs";
    }

    @GetMapping("/nuevo")
    public String nuevoBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "/private/admin/blogs/blog_form";
    }

    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable long id, Model model) {
        Optional<Blog> blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog.get());
        System.out.println(blog.get().getTitulo());
        return "private/admin/blogs/blog_form";
    }

    @PostMapping("/guardar")
    public String guardarBlog(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);

        return "redirect:/admin/blogs";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable long id) {
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }
}
