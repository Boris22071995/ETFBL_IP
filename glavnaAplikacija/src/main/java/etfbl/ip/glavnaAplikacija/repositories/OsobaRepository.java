package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Integer> {
    List<Osoba> findAll();
    Osoba save(Osoba osoba);
    Optional<Osoba> findById(Integer id);
    void deleteById(Integer id);
}
