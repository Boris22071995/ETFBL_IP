package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Osoba;
import etfbl.ip.glavnaAplikacija.models.requests.OsobaRequest;
import etfbl.ip.glavnaAplikacija.services.OsobaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/osoba")
public class OsobaController {
    OsobaService osobaService;
    public OsobaController(OsobaService osobaService) {
        this.osobaService = osobaService;
    }

    @PostMapping
    public ResponseEntity<Osoba> createOsoba(@Validated @RequestBody OsobaRequest osobaRequest) {
        Osoba osoba = osobaService.createOsoba(osobaRequest);
        return new ResponseEntity<>(osoba, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Osoba> getAll() {
        return osobaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Osoba> getOsoba(@PathVariable("id") Integer id) {
        Optional<Osoba> osoba = osobaService.getOsoba(id);
        return osoba.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        osobaService.delete(id);
    }
}
