package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Kvar;
import etfbl.ip.glavnaAplikacija.models.requests.KvarRequest;
import etfbl.ip.glavnaAplikacija.services.KvarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kvar")
public class KvarController {
    KvarService kvarService;
    public KvarController(KvarService kvarService) {
        this.kvarService = kvarService;
    }

    @PostMapping
    public ResponseEntity<Kvar> createKvar(@Validated @RequestBody KvarRequest kvarRequest) {
        Kvar kvar = kvarService.createKvar(kvarRequest);
        return new ResponseEntity<>(kvar, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Kvar> getAll() {
        return kvarService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kvar> getKvar(@PathVariable("id") Integer id) {
        Optional<Kvar> kvar = kvarService.getKvar(id);
        return kvar.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        kvarService.delete(id);
    }
}
