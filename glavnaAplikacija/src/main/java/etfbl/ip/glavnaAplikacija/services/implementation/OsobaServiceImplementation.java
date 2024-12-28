package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Osoba;
import etfbl.ip.glavnaAplikacija.models.requests.OsobaRequest;
import etfbl.ip.glavnaAplikacija.repositories.OsobaRepository;
import etfbl.ip.glavnaAplikacija.services.OsobaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OsobaServiceImplementation implements OsobaService {
    @Autowired
    private final OsobaRepository osobaRepository;

    public OsobaServiceImplementation(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    @Override
    public List<Osoba> getAll() {
        return osobaRepository.findAll();
    }

    @Override
    public Osoba createOsoba(OsobaRequest osobaRequest) {
        Osoba osoba = Osoba.builder().idOsoba(osobaRequest.getIdOsoba()).ime(osobaRequest.getIme())
                      .prezime(osobaRequest.getPrezime()).korisnickoIme(osobaRequest.getKorisnickoIme())
                        .lozinka(osobaRequest.getLozinka()).build();
        Osoba saved = osobaRepository.save(osoba);
        return saved;
    }

    @Override
    public Optional<Osoba> getOsoba(Integer id) {
        log.info("Prikupljanje podataka o osobi: " + id);
        return osobaRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        osobaRepository.deleteById(id);
    }
}
