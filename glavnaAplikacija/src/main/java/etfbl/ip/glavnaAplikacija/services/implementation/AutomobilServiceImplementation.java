package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Automobil;
import etfbl.ip.glavnaAplikacija.models.requests.AutomobilRequest;
import etfbl.ip.glavnaAplikacija.repositories.AutomobilRepository;
import etfbl.ip.glavnaAplikacija.services.AutomobilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AutomobilServiceImplementation implements AutomobilService {
    @Autowired
    private final AutomobilRepository automobilRepository;

    public AutomobilServiceImplementation(AutomobilRepository automobilRepository) {
        this.automobilRepository = automobilRepository;
    }

    @Override
    public List<Automobil> getAll() {
        return automobilRepository.findAll();
    }

    @Override
    public Automobil createAutomobil(AutomobilRequest automobilRequest) {
        Automobil automobil = Automobil.builder().vozilUuid(automobilRequest.getVozilUuid()).opis(automobilRequest.getOpis()).build();
        Automobil saved = automobilRepository.save(automobil);
        return saved;
    }

    @Override
    public Optional<Automobil> getAutomobil(String id) {
        log.info("Priklupljanje automobila: " + id);
        return automobilRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        automobilRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAllAutomobilWithVozilo() {
        return automobilRepository.findAllAutomobilWithVozilo();
    }
}
