package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Zaposleni;
import etfbl.ip.glavnaAplikacija.models.requests.ZaposleniRequest;
import etfbl.ip.glavnaAplikacija.services.ZaposleniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zaposleni")
public class ZaposleniController {
    ZaposleniService zaposleniService;

    public ZaposleniController(ZaposleniService zaposleniService) {
        this.zaposleniService = zaposleniService;
    }

    @PostMapping
    public ResponseEntity<Zaposleni> createZaposleni(@Validated @RequestBody ZaposleniRequest zaposleniRequest) {
        Zaposleni zaposleni = zaposleniService.createZaposleni(zaposleniRequest);
        return new ResponseEntity<>(zaposleni, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Zaposleni> getAll() {
        return zaposleniService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zaposleni> getZaposleni(@PathVariable("id") Integer id) {
        Optional<Zaposleni> zaposleni = zaposleniService.getZaposleni(id);
        return zaposleni.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        delete(id);
    }
}
