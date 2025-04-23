package ProyectoG2.dao;

import ProyectoG2.domain.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosDao extends JpaRepository<Productos, Long> {

    List<Productos> findByNombreArticuloContainingIgnoreCase(String nombreArticulo);

    List<Productos> findByMarca(String marca);

    List<Productos> findBySexo(String sexo);

    List<Productos> findByTalla(String talla);

    List<Productos> findByNombreArticuloContainingIgnoreCaseAndMarcaAndSexoAndTalla(
        String nombreArticulo, String marca, String sexo, String talla
    );
}
