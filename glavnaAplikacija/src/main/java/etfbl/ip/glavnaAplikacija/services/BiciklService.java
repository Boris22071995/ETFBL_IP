package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Bicikl;
import etfbl.ip.glavnaAplikacija.models.requests.BiciklRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BiciklService {
    List<Bicikl> getAll();
    Bicikl createBicikl(BiciklRequest biciklRequest);
    Optional<Bicikl> getBicikl(String id);
    void delete(String id);
    List<Object[]> getAllBiciklWithVozilo();
}
