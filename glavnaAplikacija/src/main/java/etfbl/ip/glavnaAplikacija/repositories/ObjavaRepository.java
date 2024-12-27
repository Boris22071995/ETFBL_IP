package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Objava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjavaRepository extends JpaRepository<Objava, Integer> {
    List<Objava> findAll();
    Objava save(Objava objava);
    Optional<Objava> findById(Integer id);
    void deleteById(Integer id);
}
