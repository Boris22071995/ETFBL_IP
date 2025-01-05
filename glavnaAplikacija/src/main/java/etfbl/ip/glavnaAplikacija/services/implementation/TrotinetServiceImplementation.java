package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Trotinet;
import etfbl.ip.glavnaAplikacija.models.Vozilo;
import etfbl.ip.glavnaAplikacija.models.requests.TrotinetRequest;
import etfbl.ip.glavnaAplikacija.repositories.TrotinetRepository;
import etfbl.ip.glavnaAplikacija.services.TrotinetService;
import etfbl.ip.glavnaAplikacija.services.VoziloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrotinetServiceImplementation implements TrotinetService {
    @Autowired
    private final TrotinetRepository trotinetRepository;

    @Autowired
    VoziloService voziloService;

    public TrotinetServiceImplementation(TrotinetRepository trotinetRepository) {
        this.trotinetRepository = trotinetRepository;
    }

    @Override
    public List<Trotinet> getAll() {
        return trotinetRepository.findAll();
    }

    @Override
    public Trotinet createTrotinet(TrotinetRequest trotinetRequest) {
        Trotinet trotinet = Trotinet.builder().voziloUuid(trotinetRequest.getVoziloUuid()).maksimalnaBrzina(trotinetRequest.getMaksimalnaBrzina()).build();

        Trotinet saved = trotinetRepository.save(trotinet);
        return saved;
    }

    @Override
    public Optional<Trotinet> getTrotinet(String id) {
        log.info("Prikupljanje trotineta: " + id);
        return trotinetRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        trotinetRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAllTrotinetWithVozilo() {
        return trotinetRepository.findAllTrotinetWithVozilo();
    }
}
