package ProyectoG2.service;

import java.util.List;

import ProyectoG2.domain.Promociones;

public interface PromocionesService {
    public List<Promociones> getPromociones();

    public Promociones getPromociones(int id);

    public void save(Promociones Promociones);

    public void delete(Promociones Promociones);
}
