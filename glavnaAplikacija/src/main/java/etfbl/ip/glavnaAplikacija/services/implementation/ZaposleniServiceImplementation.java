package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Zaposleni;
import etfbl.ip.glavnaAplikacija.models.requests.ZaposleniRequest;
import etfbl.ip.glavnaAplikacija.repositories.ZaposleniRepository;
import etfbl.ip.glavnaAplikacija.services.ZaposleniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ZaposleniServiceImplementation implements ZaposleniService {
   @Autowired
   private final ZaposleniRepository zaposleniRepository;

   public ZaposleniServiceImplementation(ZaposleniRepository zaposleniRepository) {
       this.zaposleniRepository = zaposleniRepository;
   }

    @Override
    public List<Zaposleni> getAll() {
        return zaposleniRepository.findAll();
    }

    @Override
    public Zaposleni createZaposleni(ZaposleniRequest zaposleniRequest) {
       Zaposleni zaposleni = Zaposleni.builder().idOsoba(zaposleniRequest.getIdOsoba()).radnoMjesto(zaposleniRequest.getRadnoMjesto()).build();
       Zaposleni saved = zaposleniRepository.save(zaposleni);
        return saved;
    }

    @Override
    public Optional<Zaposleni> getZaposleni(Integer id) {
       log.info("Prikupljanje podataka o zaposlenom: " + id);
        return zaposleniRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        zaposleniRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAllZaposleniWithOsoba() {
        return zaposleniRepository.findAllZaposleniWithOsoba();
    }
}
