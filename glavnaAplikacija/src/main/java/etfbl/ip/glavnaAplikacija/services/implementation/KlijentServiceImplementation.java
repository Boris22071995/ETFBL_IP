package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Klijent;
import etfbl.ip.glavnaAplikacija.models.requests.KlijentRequest;
import etfbl.ip.glavnaAplikacija.repositories.KlijentRepository;
import etfbl.ip.glavnaAplikacija.services.KlijentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KlijentServiceImplementation implements KlijentService {
    @Autowired
    private final KlijentRepository klijentRepository;

    public KlijentServiceImplementation(KlijentRepository klijentRepository) {
        this.klijentRepository = klijentRepository;
    }

    @Override
    public List<Klijent> getAll() {
        return klijentRepository.findAll();
    }

    @Override
    public Klijent createKlijent(KlijentRequest klijentRequest) {
        Klijent klijent = Klijent.builder().idOsoba(klijentRequest.getIdOsoba()).brojLicneKarte(klijentRequest.getBrojLicneKarte())
                          .email(klijentRequest.getEmail()).brojTelefona(klijentRequest.getBrojTelefona())
                          .avatar(klijentRequest.getAvatar()).brojKartice(klijentRequest.getBrojKartice())
                          .brojPasosa(klijentRequest.getBrojPasosa()).brojVozacke(klijentRequest.getBrojVozacke())
                          .blokiran(klijentRequest.getBlokiran()).build();
        Klijent saved = klijentRepository.save(klijent);
        return saved;
    }

    @Override
    public Optional<Klijent> getKlijent(Integer id) {
        log.info("Prikupljanje podataka za klijenta: " + id);
        return klijentRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        klijentRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAllZaposleniWithOsoba() {
        return klijentRepository.findAllKlijentWithOsoba();
    }
}
