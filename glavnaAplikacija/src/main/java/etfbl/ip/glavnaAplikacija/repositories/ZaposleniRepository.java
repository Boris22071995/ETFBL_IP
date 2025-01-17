package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Zaposleni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZaposleniRepository extends JpaRepository<Zaposleni, Integer> {
    List<Zaposleni> findAll();
    Zaposleni save(Zaposleni zaposleni);
    Optional<Zaposleni> findById(Integer id);
    void deleteById(Integer id);

    @Query(value = "SELECT z.*, o.ime, o.prezime, o.korisnickoIme FROM zaposleni z JOIN osoba o ON z.idOsoba = o.idOsoba", nativeQuery = true)
    List<Object[]> findAllZaposleniWithOsoba();
}
