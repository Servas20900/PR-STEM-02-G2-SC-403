package ProyectoG2.service.impl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoG2.dao.RolDao;
import ProyectoG2.domain.Rol;
import ProyectoG2.service.RolService;



@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> getRoles() {
        return rolDao.findAll();
    }

    @Override
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }

    // @Override
    // public List<Rol> findByIdUsuario(Long idUsuario) {
    //     return rolDao.findByIdUsuario(idUsuario);
    // }

    // @Override
    // public List<Rol> findByNombre(String nombre) {
    //     return rolDao.findByNombre(nombre);
    // }

}
