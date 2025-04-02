package ProyectoG2.controller;

import ProyectoG2.domain.Blog;
import ProyectoG2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/listado")
    public String listarBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "private/blog/listado"; 
    }

    @GetMapping("/nuevo")
    public String nuevoBlog(Model model) {
        model.addAttribute("blog", new Blog("", "", "", ""));
        return "private/blog/formulario";  
    }

    @PostMapping("/guardar")
    public String guardarBlog(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:private/blog/listado"; 
    }

}
