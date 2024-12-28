package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Racun;
import etfbl.ip.glavnaAplikacija.models.requests.RacunRequest;
import etfbl.ip.glavnaAplikacija.services.RacunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/racun")
public class RacunController {
    RacunService racunService;

    public RacunController(RacunService racunService) {
        this.racunService = racunService;
    }

    @PostMapping
    public ResponseEntity<Racun> createRacun(@Validated @RequestBody RacunRequest racunRequest) {
        Racun racun = racunService.createRacun(racunRequest);
        return new ResponseEntity<>(racun, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Racun> getAll() {
        return racunService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Racun> getRacun(@PathVariable("id") Integer id) {
        Optional<Racun> racun = racunService.getRacun(id);
        return racun.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        racunService.delete(id);
    }
}
