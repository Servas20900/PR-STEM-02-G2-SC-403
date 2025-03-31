package ProyectoG2.service;

import ProyectoG2.domain.Clase;

import java.util.List;

public interface ClaseService {

    public List<Clase> getClases();

    public void save(Clase clase);

    public void delete(Clase clase);
}
