package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Proizvodjac;
import etfbl.ip.glavnaAplikacija.models.requests.ProizvodjacRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProizvodjacService {
    List<Proizvodjac> getAll();
    Proizvodjac createProizvodjac(ProizvodjacRequest proizvodjacRequest);
    Optional<Proizvodjac> getProizvodjac(Integer id);
    void delete(Integer id);
}
