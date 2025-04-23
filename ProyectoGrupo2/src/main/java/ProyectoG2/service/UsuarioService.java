package ProyectoG2.service;

import java.util.List;
import java.util.Optional;

import ProyectoG2.domain.Usuario;
public interface UsuarioService {
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public Usuario getUsuarioPorUsername(String username);

    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);

  
    
    public void save(Usuario usuario);

    public void save1(Usuario usuario);

    public void delete(Usuario usuario);


}