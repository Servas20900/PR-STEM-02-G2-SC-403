package ProyectoG2.service.impl;

import ProyectoG2.dao.PromocionesDao;
import ProyectoG2.domain.Promociones;
import ProyectoG2.service.PromocionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromocionesServiceImpl implements PromocionesService{

    @Autowired
    private PromocionesDao promocionesDao;

    @Override
    public List<Promociones> getPromociones() {
        return promocionesDao.findAll();
    }

    @Override
    public Promociones getPromociones(int id) {
        Optional<Promociones> promocion = promocionesDao.findById(id);
        return promocion.orElse(null); // Retorna null si no se encuentra el usuario
    }
    @Override
    public void save(Promociones Promociones) {
        promocionesDao.save(Promociones);
    }

    @Override
    public void delete(Promociones Promociones) {
        promocionesDao.delete(Promociones);
    }
}
