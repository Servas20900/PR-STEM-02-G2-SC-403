package ProyectoG2.service.impl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoG2.dao.RutaDao;
import ProyectoG2.domain.Ruta;
import ProyectoG2.service.RutaService;



@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaDao rutaDao;

    @Override
    public List<Ruta> getRutas() {
        return rutaDao.findAll();
    }

    @Override
    public Ruta getRuta(Ruta ruta) {
        return rutaDao.findById(ruta.getIdRuta()).orElse(null);
    }

    @Override
    public void save(Ruta ruta) {
        rutaDao.save(ruta);
    }

    @Override
    public void delete(Ruta ruta) {
        rutaDao.delete(ruta);
    }
}
