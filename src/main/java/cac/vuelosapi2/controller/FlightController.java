package cac.vuelosapi2.controller;

import cac.vuelosapi2.models.Dolar;
import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.models.FlightDto;
import cac.vuelosapi2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//recibe las peticiones
@RequestMapping("/flights")//nos permite saber cual va a ser la direccion
public class FlightController {
    @Autowired//inyectamos
    FlightService flightService;

    @CrossOrigin
    @GetMapping("")//devuelve todos los vuelos
    public List<FlightDto> getAllFlights(){
        return flightService.getAllFlights();
    }

    @PostMapping("/add")
    public Optional<Flight> createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight,companyId);
    }

    @GetMapping("/{id}")//devuelve un vuelo por el id
    public Flight findFlightById(@PathVariable Long id){
        return flightService.findFlightById(id);
    }
    @DeleteMapping("/delete/{id}")//elimina un vuelo
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }
    @PutMapping("/update")//modificar un vuelo
    public Optional<Flight> updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }
    @GetMapping("/origin")
    public List<Flight> getFlightByLocation(@RequestParam String origin){
        return flightService.getByOrigin(origin);
    }
    @GetMapping("/location")
    public List<Flight> getFlightByLocation(@RequestParam String origin, @RequestParam String destiny){
        return flightService.getByOriginAndDestiny(origin, destiny);
    }
    @GetMapping("/flight-offers")
    public List<Flight> getOffers(@RequestParam Integer offerPrice){
        return flightService.getOffers(offerPrice);
    }

}
