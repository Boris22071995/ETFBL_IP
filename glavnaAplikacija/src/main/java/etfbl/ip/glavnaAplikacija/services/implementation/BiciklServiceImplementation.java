package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Bicikl;
import etfbl.ip.glavnaAplikacija.models.requests.BiciklRequest;
import etfbl.ip.glavnaAplikacija.repositories.BiciklRepository;
import etfbl.ip.glavnaAplikacija.services.BiciklService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BiciklServiceImplementation implements BiciklService {
   @Autowired
   private final BiciklRepository biciklRepository;

   public BiciklServiceImplementation(BiciklRepository biciklRepository) {
       this.biciklRepository = biciklRepository;
   }

    @Override
    public List<Bicikl> getAll() {
        return biciklRepository.findAll();
    }

    @Override
    public Bicikl createBicikl(BiciklRequest biciklRequest) {
       Bicikl bicikl = Bicikl.builder().voziloUuid(biciklRequest.getVoziloUuid()).domet(biciklRequest.getDomet()).build();
       Bicikl saved = biciklRepository.save(bicikl);
       return saved;
    }

    @Override
    public Optional<Bicikl> getBicikl(String id) {
        log.info("Prikupljanje bicikla: " + id);
        return biciklRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        biciklRepository.deleteById(id);
    }
}
