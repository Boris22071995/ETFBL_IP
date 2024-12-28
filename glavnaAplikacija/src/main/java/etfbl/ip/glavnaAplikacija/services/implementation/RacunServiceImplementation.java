package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Racun;
import etfbl.ip.glavnaAplikacija.models.requests.RacunRequest;
import etfbl.ip.glavnaAplikacija.repositories.RacunRepository;
import etfbl.ip.glavnaAplikacija.services.RacunService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RacunServiceImplementation implements RacunService {
    @Autowired
    private final RacunRepository racunRepository;

    public RacunServiceImplementation(RacunRepository racunRepository) {
        this.racunRepository = racunRepository;
    }

    @Override
    public List<Racun> getAll() {
        return racunRepository.findAll();
    }

    @Override
    public Racun createRacun(RacunRequest racunRequest) {
        Racun racun = Racun.builder().idracun(racunRequest.getIdracun()).idIznajmljivanja(racunRequest.getIdIznajmljivanja())
                      .iznos(racunRequest.getIznos()).pdfFajl(racunRequest.getPdfFajl()).build();
        Racun saved = racunRepository.save(racun);
        return racun;
    }

    @Override
    public Optional<Racun> getRacun(Integer id) {
        log.info("Pribavljanje racuna: " + id);
        return racunRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        racunRepository.deleteById(id);
    }
}
