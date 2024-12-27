package etfbl.ip.glavnaAplikacija.services.implementation;

import etfbl.ip.glavnaAplikacija.models.Objava;
import etfbl.ip.glavnaAplikacija.models.requests.ObjavaRequest;
import etfbl.ip.glavnaAplikacija.repositories.ObjavaRepository;
import etfbl.ip.glavnaAplikacija.services.ObjavaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ObjavaServiceImplementation implements ObjavaService {
    @Autowired
    private final ObjavaRepository objavaRepository;

    public ObjavaServiceImplementation(ObjavaRepository objavaRepository) {
        this.objavaRepository = objavaRepository;
    }

    @Override
    public List<Objava> getAll() {
        return objavaRepository.findAll();
    }

    @Override
    public Objava createObjava(ObjavaRequest objavaRequest) {
        Objava objava = Objava.builder().idObjava(objavaRequest.getIdObjava()).naslov(objavaRequest.getNaslov()).sadrzaj(objavaRequest.getSadrzaj()).build();
        Objava saved = objavaRepository.save(objava);
        return saved;
    }

    @Override
    public Optional<Objava> getObjava(Integer id) {
        log.info("Prikupljanje objave: " + id);
        return objavaRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        objavaRepository.deleteById(id);
    }
}
