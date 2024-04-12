package cac.vuelosapi2.utils;


import cac.vuelosapi2.models.Flight;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {
    public List<Flight> detectOffers(List<Flight> flight, double offerPrice){
        return flight.stream()
                .filter(Flight-> Flight.getPrice()<offerPrice)
                .collect(Collectors.toList());
    }
}
