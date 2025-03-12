package ProyectoG2.service;

import java.util.List;
import ProyectoG2.domain.Usuario;

public interface UsuarioService{

    // Obtener todos los usuarios
    public List<Usuario> getUsuarios();

    // Obtener un usuario a partir de su ID
    public Usuario getUsuario(Long id);

    // Insertar un nuevo usuario si su ID está vacío
    // Actualizar un usuario si su ID NO está vacío
    public void save(Usuario Usuario);
}