package ProyectoG2.service;

import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Usuario;

import java.util.List;

public interface InscripcionService {
    public boolean crearInscripcion(Usuario usuario, Clase clase);

    public List<Clase> findClasesByUsuario(Usuario usuario);
}
