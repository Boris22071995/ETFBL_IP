package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Automobil;
import etfbl.ip.glavnaAplikacija.models.requests.AutomobilRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AutomobilService {
    List<Automobil> getAll();
    Automobil createAutomobil(AutomobilRequest automobilRequest);
    Optional<Automobil> getAutomobil(String id);
    void delete(String id);
}
