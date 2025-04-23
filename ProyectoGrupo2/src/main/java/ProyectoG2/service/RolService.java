package ProyectoG2.service;

import java.util.List;
import ProyectoG2.domain.Rol;

public interface RolService {

    public List<Rol> getRoles();

    public Rol getRol(Rol rol);

    public void save(Rol rol);

    public void delete(Rol rol);

    // List<Rol> findByIdUsuario(Long idUsuario);

    // List<Rol> findByNombre(String nombre);
}
