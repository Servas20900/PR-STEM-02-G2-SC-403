package ProyectoG2.service;

import ProyectoG2.domain.Productos;
import java.util.List;

public interface ProductosService {

    List<Productos> listarProductos();

    List<Productos> buscarPorNombre(String nombreArticulo);

    List<Productos> buscarPorFiltros(String nombreArticulo, String marca, String sexo, String talla);

    Productos buscarPorId(Long id); 
}
