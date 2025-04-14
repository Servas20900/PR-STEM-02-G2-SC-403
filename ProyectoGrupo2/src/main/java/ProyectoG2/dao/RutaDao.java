package ProyectoG2.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoG2.domain.Ruta;

public interface RutaDao extends JpaRepository<Ruta, Long> {

    // Buscar rutas asociadas a un rol específico
    List<Ruta> findByRolName(String rolName);
}