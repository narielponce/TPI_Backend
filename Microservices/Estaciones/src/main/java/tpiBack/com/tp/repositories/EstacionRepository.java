package tpiBack.com.tp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpiBack.com.tp.models.Estacion;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Long> {

}
