package cac.vuelosapi2.service;

import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightService {
   @Autowired
   FlightRepository flightRepository;
   public List<Flight> getAllFlights() {
       return flightRepository.findAll();
   }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight findFlightById(long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight updateFlight(Flight flight) {
        flightRepository.save(flight);
        return  flightRepository.findById(flight.getId()).orElse(null);
    }
}
