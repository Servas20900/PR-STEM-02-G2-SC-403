package ProyectoG2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoG2.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    
}
