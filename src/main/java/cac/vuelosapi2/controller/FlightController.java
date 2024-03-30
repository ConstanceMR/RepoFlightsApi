package cac.vuelosapi2.controller;

import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//recibe las peticiones
@RequestMapping("/vuelos")//nos permite saber cual va a ser la direccion
public class FlightController {
    @Autowired//inyectamos
    FlightService flightService;

    @GetMapping("")//devuelve todos los vuelos
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }
    @PostMapping("/agregar")//agregar vuelos
    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }
    @GetMapping("/{id}")//devuelve un vuelo por el id
    public Flight findFlightById(@PathVariable Long id){
        return flightService.findFlightById(id);
    }
    @DeleteMapping("/eliminar/{id}")//elimina un vuelo
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }
    @PutMapping("/actualizar")//modificar un vuelo
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

}
