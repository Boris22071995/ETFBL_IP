package etfbl.ip.glavnaAplikacija.repositories;

import etfbl.ip.glavnaAplikacija.models.Trotinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrotinetRepository extends JpaRepository<Trotinet,String> {
    List<Trotinet> findAll();
    Trotinet save(Trotinet trotinet);
    Optional<Trotinet> findById(String id);
    void deleteById(String id);
}
