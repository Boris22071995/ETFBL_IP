package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Osoba;
import etfbl.ip.glavnaAplikacija.models.requests.OsobaRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OsobaService {
    List<Osoba> getAll();
    Osoba createOsoba(OsobaRequest osobaRequest);
    Optional<Osoba> getOsoba(Integer id);
    void delete(Integer id);
}
