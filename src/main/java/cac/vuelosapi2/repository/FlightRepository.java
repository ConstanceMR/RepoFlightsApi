package cac.vuelosapi2.repository;

import cac.vuelosapi2.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
