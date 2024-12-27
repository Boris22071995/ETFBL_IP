package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Objava;
import etfbl.ip.glavnaAplikacija.models.requests.ObjavaRequest;
import etfbl.ip.glavnaAplikacija.services.ObjavaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objava")
public class ObjavaController {
    ObjavaService objavaService;
    public ObjavaController(ObjavaService objavaService) {
        this.objavaService = objavaService;
    }

    @PostMapping
    public ResponseEntity<Objava> createObjava(@Validated @RequestBody ObjavaRequest objavaRequest) {
        Objava objava = objavaService.createObjava(objavaRequest);
        return new ResponseEntity<>(objava, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Objava> getAll(){
        return objavaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objava> getObjava(@PathVariable("id") Integer id) {
        Optional<Objava> objava = objavaService.getObjava(id);
        return objava.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        objavaService.delete(id);
    }
}
