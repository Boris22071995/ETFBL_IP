package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Promocija;
import etfbl.ip.glavnaAplikacija.models.requests.PromocijaRequest;
import etfbl.ip.glavnaAplikacija.services.PromocijaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promocija")
public class PromocijaController {
    PromocijaService promocijaService;
    public PromocijaController(PromocijaService promocijaService) {
        this.promocijaService = promocijaService;
    }

    @PostMapping
    public ResponseEntity<Promocija> createPromocija(@Validated @RequestBody PromocijaRequest promocijaRequest) {
        Promocija promocija = promocijaService.createPromocija(promocijaRequest);
        return new ResponseEntity<>(promocija, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Promocija> getAll() {
        return promocijaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocija> getPromocija(@PathVariable("id") Integer id) {
        Optional<Promocija> promocija = promocijaService.getPromocija(id);
        return promocija.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        promocijaService.delete(id);
    }
}
