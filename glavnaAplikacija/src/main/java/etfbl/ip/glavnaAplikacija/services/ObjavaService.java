package etfbl.ip.glavnaAplikacija.services;

import etfbl.ip.glavnaAplikacija.models.Objava;
import etfbl.ip.glavnaAplikacija.models.requests.ObjavaRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ObjavaService {
    List<Objava> getAll();
    Objava createObjava(ObjavaRequest objavaRequest);
    Optional<Objava> getObjava(Integer id);
    void delete(Integer id);
}
