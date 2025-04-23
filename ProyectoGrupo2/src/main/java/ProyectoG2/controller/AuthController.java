// package ProyectoG2.controller;

// import ProyectoG2.domain.Rol;
// import ProyectoG2.domain.Usuario;
// import ProyectoG2.service.RolService;
// import ProyectoG2.service.UsuarioService;

// import jakarta.servlet.http.HttpSession;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.Collections;

// @Controller
// @RequestMapping("/register")
// public class AuthController {

//     @Autowired
//     private UsuarioService usuarioService;

//     @Autowired
//     private RolService rolService;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @GetMapping("/register")
//     public String mostrarRegistro(Model model) {
//         model.addAttribute("usuario", new Usuario());
//         return "register";
//     }

//     @PostMapping("/register")
//     public String register(@ModelAttribute Usuario usuario, Model model) {
//         if (usuarioService.existsByUsernameOrCorreo(usuario.getUsername(), usuario.getCorreo())) {
//             model.addAttribute("error", "El nombre de usuario o correo ya está en uso");
//             return "register";
//         }

//         usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//         Rol rolUser = rolService.findByNombre("USER").get(0);
//         usuario.setRoles(Collections.singletonList(rolUser));

//         usuarioService.save(usuario);

//         model.addAttribute("success", "Usuario registrado exitosamente");
//         return "/login";
//     }
// }
