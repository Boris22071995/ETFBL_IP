package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Trotinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrotinetRepository extends JpaRepository<Trotinet,String> {
    List<Trotinet> findAll();
    Trotinet save(Trotinet trotinet);
    Optional<Trotinet> findById(String id);
    void deleteById(String id);

    @Query(value = "SELECT t.*, v.datumNabavke, v.cijenaNabavke, v.model, v.pokvareno, v.iznajmljeno, v.slika, v.idProizvodjac FROM trotinet t JOIN vozilo v ON t.voziloUuid = v.uuid", nativeQuery = true)
    List<Object[]> findAllTrotinetWithVozilo();
}
