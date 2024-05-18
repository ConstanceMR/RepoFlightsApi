package cac.vuelosapi2.utils;


import cac.vuelosapi2.models.Flight;
import cac.vuelosapi2.models.FlightDto;
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

    public List<FlightDto> flightMapperList(List<Flight> flightList, double dolarPrice){
        return flightList.stream()
                .map(flight-> new FlightDto(flight.getId(), flight.getDestiny(), flight.getOrigin(), flight.getDepartureDate(), flight.getArrivingDate(), flight.getFrecuency(), flight.getPrice()*dolarPrice))
                .collect(Collectors.toList());
    }
}
