package ProyectoG2.service.impl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoG2.dao.RutaPermitDao;
import ProyectoG2.domain.RutaPermit;
import ProyectoG2.service.RutaPermitService;



@Service
public class RutaPermitServiceImpl implements RutaPermitService {

    @Autowired
    private RutaPermitDao rutaPermitDao;

    @Override
    public List<RutaPermit> getRutaPermits() {
        return rutaPermitDao.findAll();
    }

    @Override
    public RutaPermit getRutaPermit(RutaPermit rutaPermit) {
        return rutaPermitDao.findById(rutaPermit.getIdRuta()).orElse(null);
    }

    @Override
    public void save(RutaPermit rutaPermit) {
        rutaPermitDao.save(rutaPermit);
    }

    @Override
    public void delete(RutaPermit rutaPermit) {
        rutaPermitDao.delete(rutaPermit);
    }
}
