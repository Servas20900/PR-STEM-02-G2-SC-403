package ProyectoG2.service;

import ProyectoG2.domain.Clase;

import java.util.List;
import java.util.Optional;

public interface ClaseService {

    public List<Clase> getClases();

    public Optional<Clase> getClaseById(int id);

    public void save(Clase clase);

    public void delete(Clase clase);

    public void deleteById(int id);
}
