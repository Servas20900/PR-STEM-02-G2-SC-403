package ProyectoG2.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ProyectoG2.domain.Ruta;

public interface RutaDao extends JpaRepository<Ruta, Long> {

    List<Ruta> findByRolName(String rolName);
}