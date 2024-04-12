package cac.vuelosapi2.repository;

import cac.vuelosapi2.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOrigin(String Origin);

    List<Flight> findByOriginAndDestiny(String origin, String destiny);



}
