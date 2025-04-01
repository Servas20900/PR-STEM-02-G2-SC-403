package ProyectoG2.service.impl;

import ProyectoG2.dao.PromocionesDao;
import ProyectoG2.domain.Promociones;
import ProyectoG2.service.PromocionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromocionesServiceImpl implements PromocionesService {

    @Autowired
    private PromocionesDao promocionesDao;

    @Override
    public List<Promociones> getPromociones() {
        return promocionesDao.findAll();
    }

    @Override
    public Promociones getPromocion(Long id) {
        return promocionesDao.findById(id).orElse(null);
    }
}

