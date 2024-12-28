package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Vozilo;
import etfbl.ip.glavnaAplikacija.models.requests.VoziloRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VoziloService {
    List<Vozilo> getAll();
    Vozilo createVozilo(VoziloRequest voziloRequest);
    Optional<Vozilo> getVozilo(String id);
    void delete(String id);
}
