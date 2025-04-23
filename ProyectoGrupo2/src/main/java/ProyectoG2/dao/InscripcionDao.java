package ProyectoG2.dao;

import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Inscripcion;
import ProyectoG2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

public interface InscripcionDao extends JpaRepository<Inscripcion, Integer> {
    boolean existsByUsuarioAndClase(Usuario usuario, Clase clase);
}
