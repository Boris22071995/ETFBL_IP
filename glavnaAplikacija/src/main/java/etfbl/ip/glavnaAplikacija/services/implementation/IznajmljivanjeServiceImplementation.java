package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Iznajmljivanje;
import etfbl.ip.glavnaAplikacija.models.requests.IznajmljivanjeRequest;
import etfbl.ip.glavnaAplikacija.repositories.IznajmljivanjeRepository;
import etfbl.ip.glavnaAplikacija.services.IznajmljivanjeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class IznajmljivanjeServiceImplementation implements IznajmljivanjeService {
    @Autowired
    private final IznajmljivanjeRepository iznajmljivanjeRepository;

    public IznajmljivanjeServiceImplementation(IznajmljivanjeRepository iznajmljivanjeRepository) {
        this.iznajmljivanjeRepository = iznajmljivanjeRepository;
    }

    @Override
    public List<Iznajmljivanje> getAll() {
        return iznajmljivanjeRepository.findAll();
    }

    @Override
    public Iznajmljivanje createIznajmljivanje(IznajmljivanjeRequest iznajmljivanjeRequest) {
        Iznajmljivanje iznajmljivanje = Iznajmljivanje.builder().idIznajmljivanja(iznajmljivanjeRequest.getIdIznajmljivanja()).idOsoba(iznajmljivanjeRequest.getIdOsoba())
                                        .voziloUuid(iznajmljivanjeRequest.getVoziloUuid()).datumIVrijemeIznajmljivanja(iznajmljivanjeRequest.getDatumIVrijemeIznajmljivanja())
                                        .lokacijaXPreuzimanja(iznajmljivanjeRequest.getLokacijaXPreuzimanja()).lokacijaYPreuzimanja(iznajmljivanjeRequest.getLokacijaYPreuzimanja())
                                        .lokacijaXOstavljanja(iznajmljivanjeRequest.getLokacijaXOstavljanja()).lokacijaYOstavljanja(iznajmljivanjeRequest.getLokacijaYOstavljanja())
                                        .trajanjeKoriscenja(iznajmljivanjeRequest.getTrajanjeKoriscenja()).build();
        Iznajmljivanje saved = iznajmljivanjeRepository.save(iznajmljivanje);
        return saved;
    }

    @Override
    public Optional<Iznajmljivanje> getIznajmljivanje(Integer id) {
        log.info("Prikupljanje informacija o iznajmljivanju: " + id);
        return iznajmljivanjeRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        iznajmljivanjeRepository.deleteById(id);
    }
}
