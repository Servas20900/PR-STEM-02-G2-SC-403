package ProyectoG2.service;

import ProyectoG2.domain.Tienda;
import java.util.List;

public interface TiendaService {
    List<Tienda> listarProductos();
    Tienda obtenerProductoPorId(Long id);
    void guardar(Tienda tienda);
    void eliminar(Long id);
}
