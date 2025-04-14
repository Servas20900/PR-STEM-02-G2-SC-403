package ProyectoG2.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoG2.domain.Rol;


public interface RolDao extends JpaRepository<Rol, Long> {

    // Buscar todos los roles asociados a un usuario
    List<Rol> findByIdUsuario(Long id);
    
    // Buscar por nombre de rol
    List<Rol> findByNombre(String nombre);
}