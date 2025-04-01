package ProyectoG2.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ProyectoG2.dao.TiendaDao;
import ProyectoG2.domain.Tienda;
import ProyectoG2.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaDao tiendaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tienda> listarProductos() {
        return tiendaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tienda obtenerProductoPorId(Long id) {
        return tiendaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Tienda tienda) {
        tiendaDao.save(tienda);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tiendaDao.deleteById(id);
    }
}