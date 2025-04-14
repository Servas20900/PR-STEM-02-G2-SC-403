package ProyectoG2.service;


import java.util.List;
import ProyectoG2.domain.RutaPermit;

public interface RutaPermitService {

    public List<RutaPermit> getRutaPermits();

    public RutaPermit getRutaPermit(RutaPermit rutaPermit);

    public void save(RutaPermit rutaPermit);

    public void delete(RutaPermit rutaPermit);
}
