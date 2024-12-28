package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Iznajmljivanje;
import etfbl.ip.glavnaAplikacija.models.requests.IznajmljivanjeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IznajmljivanjeService {
    List<Iznajmljivanje> getAll();
    Iznajmljivanje createIznajmljivanje(IznajmljivanjeRequest iznajmljivanjeRequest);
    Optional<Iznajmljivanje> getIznajmljivanje(Integer id);
    void delete(Integer id);
}
