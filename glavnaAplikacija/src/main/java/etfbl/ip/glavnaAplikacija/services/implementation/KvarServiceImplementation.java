package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Kvar;
import etfbl.ip.glavnaAplikacija.models.requests.KvarRequest;
import etfbl.ip.glavnaAplikacija.repositories.KvarRepository;
import etfbl.ip.glavnaAplikacija.services.KvarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KvarServiceImplementation implements KvarService {
    @Autowired
    private final KvarRepository kvarRepository;

    public KvarServiceImplementation(KvarRepository kvarRepository) {
        this.kvarRepository = kvarRepository;
    }

    @Override
    public List<Kvar> getAll() {
        return kvarRepository.findAll();
    }

    @Override
    public Kvar createKvar(KvarRequest kvarRequest) {
        Kvar kvar = Kvar.builder().idKvar(kvarRequest.getIdKvar()).opis(kvarRequest.getOpis()).datum(kvarRequest.getDatum()).voziloUuid(kvarRequest.getVoziloUuid()).build();
        Kvar saved = kvarRepository.save(kvar);
        return saved;
    }

    @Override
    public Optional<Kvar> getKvar(Integer id) {
        log.info("Prikupljanje kvara: " + id);
        return kvarRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        kvarRepository.deleteById(id);
    }
}
