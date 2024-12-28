package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Racun;
import etfbl.ip.glavnaAplikacija.models.requests.RacunRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RacunService {
    List<Racun> getAll();
    Racun createRacun(RacunRequest racunRequest);
    Optional<Racun> getRacun(Integer id);
    void delete(Integer id);
}
