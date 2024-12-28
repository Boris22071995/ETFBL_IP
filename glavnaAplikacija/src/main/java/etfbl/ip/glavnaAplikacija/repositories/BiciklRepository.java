package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Bicikl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BiciklRepository extends JpaRepository<Bicikl, String> {
    List<Bicikl> findAll();
    Bicikl save(Bicikl bicikl);
    Optional<Bicikl> findById(String id);
    void deleteById(String id);
}
