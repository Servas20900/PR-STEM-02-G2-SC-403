package ProyectoG2.service;

import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Usuario;

public interface InscripcionService {
    public boolean crearInscripcion(Usuario usuario, Clase clase);
}
