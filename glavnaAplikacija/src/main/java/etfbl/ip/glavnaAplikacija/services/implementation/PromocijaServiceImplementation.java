package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Promocija;
import etfbl.ip.glavnaAplikacija.models.requests.PromocijaRequest;
import etfbl.ip.glavnaAplikacija.repositories.PromocijaRepository;
import etfbl.ip.glavnaAplikacija.services.PromocijaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PromocijaServiceImplementation implements PromocijaService {
   @Autowired
   private final PromocijaRepository promocijaRepository;

   public PromocijaServiceImplementation(PromocijaRepository promocijaRepository) {
       this.promocijaRepository = promocijaRepository;
   }

    @Override
    public List<Promocija> getAll() {
        return promocijaRepository.findAll();
    }

    @Override
    public Promocija createPromocija(PromocijaRequest promocijaRequest) {
       Promocija promocija = Promocija.builder().idPromocija(promocijaRequest.getIdPromocija())
                            .naslov(promocijaRequest.getNaslov()).opis(promocijaRequest.getOpis())
                            .datumTrajanja(promocijaRequest.getDatumTrajanja()).build();
       Promocija saved = promocijaRepository.save(promocija);
       return saved;
    }

    @Override
    public Optional<Promocija> getPromocija(Integer id) {
       log.info("Prikupljanje promocije: " + id);
        return promocijaRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        promocijaRepository.deleteById(id);
    }
}
