package etfbl.ip.glavnaAplikacija.controllers;

import etfbl.ip.glavnaAplikacija.models.Trotinet;
import etfbl.ip.glavnaAplikacija.models.requests.TrotinetRequest;
import etfbl.ip.glavnaAplikacija.services.TrotinetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trotinet")
public class TrotinetController {
    TrotinetService trotinetService;

    public TrotinetController(TrotinetService trotinetService) {
        this.trotinetService = trotinetService;
    }

    @PostMapping
    public ResponseEntity<Trotinet> createTrotinet(@Validated @RequestBody TrotinetRequest trotinetRequest) {
        Trotinet trotinet = trotinetService.createTrotinet(trotinetRequest);
        return new ResponseEntity<>(trotinet, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Object[]> getAll() {
        return trotinetService.getAllTrotinetWithVozilo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trotinet> getTrotinet(@PathVariable("id") String id) {
        Optional<Trotinet> trotinet = trotinetService.getTrotinet(id);
        return trotinet.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        trotinetService.delete(id);
    }

}
