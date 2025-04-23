package ProyectoG2.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoG2.domain.Rol;


public interface RolDao extends JpaRepository<Rol, Long> {

    List<Rol> findByIdUsuario(Long id);
    
    List<Rol> findByNombre(String nombre);
}