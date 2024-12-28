package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Kvar;
import etfbl.ip.glavnaAplikacija.models.requests.KvarRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KvarService {
    List<Kvar> getAll();
    Kvar createKvar(KvarRequest kvarRequest);
    Optional<Kvar> getKvar(Integer id);
    void delete(Integer id);
}
