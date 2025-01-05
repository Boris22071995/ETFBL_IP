package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Automobil;
import etfbl.ip.glavnaAplikacija.models.requests.AutomobilRequest;
import etfbl.ip.glavnaAplikacija.services.AutomobilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobil")
public class AutomobilController {
    AutomobilService automobilService;

    public AutomobilController(AutomobilService automobilService) {
        this.automobilService = automobilService;
    }

    @PostMapping
    public ResponseEntity<Automobil> createAutomobil(@Validated @RequestBody AutomobilRequest automobilRequest) {
        Automobil automobil = automobilService.createAutomobil(automobilRequest);
        return new ResponseEntity<>(automobil, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Object[]> getAll() {
        return automobilService.getAllAutomobilWithVozilo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automobil> getAutomobil(@PathVariable("id") String id) {
        Optional<Automobil> automobil = automobilService.getAutomobil(id);
        return automobil.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        automobilService.delete(id);
    }
}
