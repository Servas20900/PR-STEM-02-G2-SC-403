package ProyectoG2.service.impl;

import ProyectoG2.dao.ProductosDao;
import ProyectoG2.domain.Productos;
import ProyectoG2.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosDao productosDao;

    @Override
    public List<Productos> listarProductos() {
        return productosDao.findAll();
    }

    @Override
    public List<Productos> buscarPorNombre(String nombreArticulo) {
        return productosDao.findByNombreArticuloContainingIgnoreCase(nombreArticulo); 
    }

    @Override
    public List<Productos> buscarPorFiltros(String nombreArticulo, String marca, String sexo, String talla) {
        List<Productos> productos = productosDao.findAll();

        if (nombreArticulo != null && !nombreArticulo.trim().isEmpty()) {
            productos = productos.stream()
                    .filter(p -> p.getNombreArticulo() != null &&
                                 p.getNombreArticulo().toLowerCase().contains(nombreArticulo.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (marca != null && !marca.isEmpty()) {
            productos = productos.stream()
                    .filter(p -> p.getMarca() != null && p.getMarca().equalsIgnoreCase(marca))
                    .collect(Collectors.toList());
        }

        if (sexo != null) {
            productos = productos.stream()
                    .filter(p -> p.getSexo() != null && p.getSexo().equals(sexo))
                    .collect(Collectors.toList());
        }

        if (talla != null) {
            productos = productos.stream()
                    .filter(p -> p.getTalla() != null && p.getTalla().equals(talla))
                    .collect(Collectors.toList());
        }

        return productos;
    }

    @Override
    public Productos buscarPorId(Long id) {
        return productosDao.findById(id).orElse(null);
    }
}
