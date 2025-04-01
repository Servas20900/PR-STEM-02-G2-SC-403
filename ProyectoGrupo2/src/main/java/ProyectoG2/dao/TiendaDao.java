package ProyectoG2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ProyectoG2.domain.Tienda;

public interface TiendaDao extends JpaRepository<Tienda, Long> {
}