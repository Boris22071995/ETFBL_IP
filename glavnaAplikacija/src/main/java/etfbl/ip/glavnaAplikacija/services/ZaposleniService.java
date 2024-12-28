package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Zaposleni;
import etfbl.ip.glavnaAplikacija.models.requests.ZaposleniRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ZaposleniService {
    List<Zaposleni> getAll();
    Zaposleni createZaposleni(ZaposleniRequest zaposleniRequest);
    Optional<Zaposleni> getZaposleni(Integer id);
    void delete(Integer id);
}
