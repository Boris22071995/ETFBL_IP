package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Proizvodjac;
import etfbl.ip.glavnaAplikacija.models.requests.ProizvodjacRequest;
import etfbl.ip.glavnaAplikacija.services.ProizvodjacService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proizvodjac")
public class ProizvodjacController {
    ProizvodjacService proizvodjacService;
    public ProizvodjacController(ProizvodjacService proizvodjacService) {
        this.proizvodjacService = proizvodjacService;
    }

    @PostMapping
    public ResponseEntity<Proizvodjac> createProizvodjac(@Validated @RequestBody ProizvodjacRequest proizvodjacRequest) {
        Proizvodjac proizvodjac = proizvodjacService.createProizvodjac(proizvodjacRequest);
        return new ResponseEntity<>(proizvodjac, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Proizvodjac> getAll() {
        return proizvodjacService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proizvodjac> getProizvodjac(@PathVariable("id") Integer id) {
        Optional<Proizvodjac> proizvodjac = proizvodjacService.getProizvodjac(id);
        return proizvodjac.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        proizvodjacService.delete(id);
    }
}
