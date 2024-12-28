package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Bicikl;
import etfbl.ip.glavnaAplikacija.models.requests.BiciklRequest;
import etfbl.ip.glavnaAplikacija.services.BiciklService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bicikl")
public class BiciklController {
    BiciklService biciklService;

    public BiciklController(BiciklService biciklService) {
        this.biciklService = biciklService;
    }

    @PostMapping
    public ResponseEntity<Bicikl> createBicikl(@Validated @RequestBody BiciklRequest biciklRequest) {
        Bicikl bicikl = biciklService.createBicikl(biciklRequest);
        return new ResponseEntity<>(bicikl, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Bicikl> getAll() {
        return biciklService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicikl> getBicikl(@PathVariable("id") String id) {
        Optional<Bicikl> bicikl = biciklService.getBicikl(id);
        return bicikl.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        biciklService.delete(id);
    }

}
