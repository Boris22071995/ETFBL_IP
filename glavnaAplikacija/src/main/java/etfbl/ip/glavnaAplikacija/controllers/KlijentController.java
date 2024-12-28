package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Klijent;
import etfbl.ip.glavnaAplikacija.models.requests.KlijentRequest;
import etfbl.ip.glavnaAplikacija.services.KlijentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klijent")
public class KlijentController {
    KlijentService klijentService;

    public KlijentController(KlijentService klijentService) {
        this.klijentService = klijentService;
    }

    @PostMapping
    public ResponseEntity<Klijent> createKlijenta(@Validated @RequestBody KlijentRequest klijentRequest) {
        Klijent klijent = klijentService.createKlijent(klijentRequest);
        return new ResponseEntity<>(klijent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Klijent> getAll() {
      return klijentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klijent> getKlijent(@PathVariable("id") Integer id) {
        Optional<Klijent> klijent = klijentService.getKlijent(id);
        return klijent.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        klijentService.delete(id);
    }


}
