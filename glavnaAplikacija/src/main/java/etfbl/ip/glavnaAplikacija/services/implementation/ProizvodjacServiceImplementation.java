package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Proizvodjac;
import etfbl.ip.glavnaAplikacija.models.requests.ProizvodjacRequest;
import etfbl.ip.glavnaAplikacija.repositories.ProizvodjacRepository;
import etfbl.ip.glavnaAplikacija.services.ProizvodjacService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProizvodjacServiceImplementation implements ProizvodjacService {
   @Autowired
   private final ProizvodjacRepository proizvodjacRepository;

   public ProizvodjacServiceImplementation(ProizvodjacRepository proizvodjacRepository) {
       this.proizvodjacRepository = proizvodjacRepository;
   }

    @Override
    public List<Proizvodjac> getAll() {
        return proizvodjacRepository.findAll();
    }

    @Override
    public Proizvodjac createProizvodjac(ProizvodjacRequest proizvodjacRequest) {
       Proizvodjac proizvodjac = Proizvodjac.builder().idProizvodjac(proizvodjacRequest.getIdProizvodjac())
                                .naziv(proizvodjacRequest.getNaziv()).drzava(proizvodjacRequest.getDrzava())
                                .adresa(proizvodjacRequest.getAdresa()).telefon(proizvodjacRequest.getTelefon())
                                .fax(proizvodjacRequest.getFax()).mail(proizvodjacRequest.getMail()).build();
       Proizvodjac saved = proizvodjacRepository.save(proizvodjac);
       return saved;
    }

    @Override
    public Optional<Proizvodjac> getProizvodjac(Integer id) {
       log.info("Prikupljanje proizvodjaca: " + id);
       return proizvodjacRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
    proizvodjacRepository.deleteById(id);
    }
}
