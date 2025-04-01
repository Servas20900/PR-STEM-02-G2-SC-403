package ProyectoG2.service;

import ProyectoG2.domain.Promociones;
import java.util.List;

public interface PromocionesService {
    List<Promociones> getPromociones();
    Promociones getPromocion(Long id);
}

