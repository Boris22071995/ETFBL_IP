package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Vozilo;
import etfbl.ip.glavnaAplikacija.models.requests.VoziloRequest;
import etfbl.ip.glavnaAplikacija.repositories.VoziloRepository;
import etfbl.ip.glavnaAplikacija.services.VoziloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VoziloServiceImplementation implements VoziloService {
    @Autowired
    private final VoziloRepository voziloRepository;

    public VoziloServiceImplementation(VoziloRepository voziloRepository) {
        this.voziloRepository = voziloRepository;
    }

    @Override
    public List<Vozilo> getAll() {
        return voziloRepository.findAll();
    }

    @Override
    public Vozilo createVozilo(VoziloRequest voziloRequest) {
        Vozilo vozilo = Vozilo.builder().uuid(voziloRequest.getUuid()).datumNabavke(voziloRequest.getDatumNabavke())
                        .cijenaNabavke(voziloRequest.getCijenaNabavke()).model(voziloRequest.getModel())
                        .pokvareno(voziloRequest.getPokvareno()).iznajmljeno(voziloRequest.getIznajmljeno())
                        .slika(voziloRequest.getSlika()).idProizvodjac(voziloRequest.getIdProizvodjac()).build();
        Vozilo saved = voziloRepository.save(vozilo);
        return saved;
    }

    @Override
    public Optional<Vozilo> getVozilo(String id) {
        log.info("Prikupljanje vozila: " + id);
        return voziloRepository.findById(id);
    }

    @Override
    public void delete(String id) {
      voziloRepository.deleteById(id);
    }
}
