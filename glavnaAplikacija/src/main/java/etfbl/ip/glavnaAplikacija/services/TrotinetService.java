package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Trotinet;
import etfbl.ip.glavnaAplikacija.models.requests.TrotinetRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrotinetService {
    List<Trotinet> getAll();
    Trotinet createTrotinet(TrotinetRequest trotinetRequest);
    Optional<Trotinet> getTrotinet(String id);
    void delete(String id);
    List<Object[]> getAllTrotinetWithVozilo();
}
