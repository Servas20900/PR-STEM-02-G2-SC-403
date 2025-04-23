package ProyectoG2.dao;

import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Inscripcion;
import ProyectoG2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionDao extends JpaRepository<Inscripcion, Integer> {
    boolean existsByUsuarioAndClase(Usuario usuario, Clase clase);

    @Query("SELECT i.clase FROM Inscripcion i WHERE i.usuario = :usuario")
    List<Clase> findClasesByUsuario(@Param("usuario") Usuario usuario);
}
