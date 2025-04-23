package ProyectoG2.service.impl;

import ProyectoG2.dao.InscripcionDao;
import ProyectoG2.domain.Clase;
import ProyectoG2.domain.Inscripcion;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionServiceImpl implements InscripcionService {
    @Autowired
    InscripcionDao inscripcionDao;

    @Override
    public boolean crearInscripcion(Usuario usuario, Clase clase) {
        if (!inscripcionDao.existsByUsuarioAndClase(usuario, clase)) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setUsuario(usuario);
            inscripcion.setClase(clase);
            inscripcionDao.save(inscripcion);

            return true;
        }

        return false;
    }
}
