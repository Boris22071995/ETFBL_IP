package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Klijent;
import etfbl.ip.glavnaAplikacija.models.requests.KlijentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KlijentService {
    List<Klijent> getAll();
    Klijent createKlijent(KlijentRequest klijentRequest);
    Optional<Klijent> getKlijent(Integer id);
    void delete(Integer id);
    List<Object[]> getAllZaposleniWithOsoba();
}
