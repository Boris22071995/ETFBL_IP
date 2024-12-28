package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Vozilo;
import etfbl.ip.glavnaAplikacija.models.requests.VoziloRequest;
import etfbl.ip.glavnaAplikacija.services.VoziloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vozilo")
public class VoziloController {
    VoziloService voziloService;

    public VoziloController(VoziloService voziloService) {
        this.voziloService = voziloService;
    }

    @PostMapping
    public ResponseEntity<Vozilo> createVozilo(@Validated @RequestBody VoziloRequest voziloRequest) {
        Vozilo vozilo = voziloService.createVozilo(voziloRequest);
        return new ResponseEntity<>(vozilo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Vozilo> getAll() {
        return voziloService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vozilo> getVozilo(@PathVariable("id") String id) {
        Optional<Vozilo> vozilo = voziloService.getVozilo(id);
        return vozilo.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        voziloService.delete(id);
    }
}
