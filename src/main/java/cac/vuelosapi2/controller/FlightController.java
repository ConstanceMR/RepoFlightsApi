package cac.vuelosapi2.controller;

import cac.vuelosapi2.models.Dolar;
import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.models.FlightDto;
import cac.vuelosapi2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @CrossOrigin
    @GetMapping("")
    public List<FlightDto> getAllFlights(){
        return flightService.getAllFlights();
    }

    @PostMapping("/add")
    public Optional<Flight> createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight,companyId);
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id){
        return flightService.findFlightById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }
    @PutMapping("/update")
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
