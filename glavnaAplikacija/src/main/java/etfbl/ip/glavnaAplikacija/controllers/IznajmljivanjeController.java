package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Iznajmljivanje;
import etfbl.ip.glavnaAplikacija.models.requests.IznajmljivanjeRequest;
import etfbl.ip.glavnaAplikacija.services.IznajmljivanjeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/iznajmljivanje")
public class IznajmljivanjeController {
    IznajmljivanjeService iznajmljivanjeService;

    public IznajmljivanjeController(IznajmljivanjeService iznajmljivanjeService) {
        this.iznajmljivanjeService = iznajmljivanjeService;
    }

    @PostMapping
    public ResponseEntity<Iznajmljivanje> createIznajmljivanje(@Validated @RequestBody IznajmljivanjeRequest iznajmljivanjeRequest) {
        Iznajmljivanje iznajmljivanje = iznajmljivanjeService.createIznajmljivanje(iznajmljivanjeRequest);
        return new ResponseEntity<>(iznajmljivanje, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Iznajmljivanje> getAll() {
        return iznajmljivanjeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iznajmljivanje> getIznajmljivanje(@PathVariable("id") Integer id) {
        Optional<Iznajmljivanje> iznajmljivanje = iznajmljivanjeService.getIznajmljivanje(id);
        return iznajmljivanje.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iznajmljivanjeService.delete(id);
    }
}
