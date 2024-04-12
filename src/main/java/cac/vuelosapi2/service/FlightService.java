package cac.vuelosapi2.service;

import cac.vuelosapi2.configuration.FlightConfiguration;
import cac.vuelosapi2.models.Dolar;
import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.repository.FlightRepository;
import cac.vuelosapi2.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
   @Autowired
   FlightRepository flightRepository;
   @Autowired
   FlightUtils flightUtils;
   @Autowired
    FlightConfiguration flightConfiguration;
   public List<Flight> getAllFlights() {
       return flightRepository.findAll();
   }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public Optional<Flight> findFlightById(long id) {
        return flightRepository.findById(id);
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public Optional<Flight> updateFlight(Flight flight) {
        flightRepository.save(flight);
        return  flightRepository.findById(flight.getId());
    }
    public List<Flight> getByOrigin(String origin){
       return flightRepository.findByOrigin(origin);
    }
    public List<Flight> getByOriginAndDestiny(String origin, String destiny){
        return flightRepository.findByOriginAndDestiny(origin, destiny);
    }

    public List<Flight> getOffers(Double offerPrice) {
       List<Flight> flights = flightRepository.findAll();
       return flightUtils.detectOffers(flights, offerPrice);
    }

    public double getDolar(){
       return flightConfiguration.fetchDolar().getPromedio();
    }

}
