package ProyectoG2.service.impl;

import ProyectoG2.domain.Clase;
import ProyectoG2.service.ClaseService;
import ProyectoG2.dao.ClaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseDao claseDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clase> getClases() {
        return claseDao.findAll();
    }

    @Override
    public Optional<Clase> getClaseById(int id) {
        return claseDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Clase clase) {
        claseDao.save(clase);
    }

    @Override
    public void delete(Clase clase) {
        claseDao.delete(clase);
    }

    @Override
    public void deleteById(int id) {claseDao.deleteById(id);}

    @Override
    public void actualizarInscripcion(int idClase) {
        getClaseById(idClase).ifPresent(clase -> {
            clase.setUsuarios_registrados(clase.getUsuarios_registrados()+1);

            claseDao.save(clase);
        });
    }
}
