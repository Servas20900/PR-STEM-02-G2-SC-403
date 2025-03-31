package ProyectoG2.service.impl;

import ProyectoG2.domain.Clase;
import ProyectoG2.service.ClaseService;
import ProyectoG2.dao.ClaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public void save(Clase clase) {
        claseDao.save(clase);
    }

    @Override
    public void delete(Clase clase) {
        claseDao.delete(clase);
    }
}
