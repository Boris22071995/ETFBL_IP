package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Promocija;
import etfbl.ip.glavnaAplikacija.models.requests.PromocijaRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PromocijaService {
    List<Promocija> getAll();
    Promocija createPromocija(PromocijaRequest promocijaRequest);
    Optional<Promocija> getPromocija(Integer id);
    void delete(Integer id);
}
