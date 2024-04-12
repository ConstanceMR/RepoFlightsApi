package cac.vuelosapi2.repository;

import cac.vuelosapi2.models.Flight;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    private Flight flight;



    @BeforeEach
    void setup(){


        flight = new Flight("Cor","Eze","8.00","11.00",200.00,"Diaria");
    }

    @DisplayName("guardar vuelo")// cambia el nombre al correr
    @Test
    void saveFlightTest(){
        //configuración previa en el setup
        //llamar la funcionalidad
        Flight flightBD = flightRepository.save(flight);
        //verificar la salida o el comportamiento
        assertThat(flightBD).isNotNull();
        // o assertThat(flightBD.getId()).isGreaterThan(0);
    }


    @DisplayName("encontrar vuelo por id")
    @Test
    void flightFindByIdTest(){
        //configuracion previa
        flightRepository.save(flight);
        //llamar a la funcionalidad
        Flight flightBD = flightRepository.findById(flight.getId()).get();
        //verificar la salida o comportamiento
        assertThat(flightBD).isNotNull();
    }


    @Test
    void flightFindAllTest(){
        //configuracion previa
        Flight flight1 = new Flight("MAD", "COR","8.00","11.00",200.0,"Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight1);

        //Llamar la funcionalidad
        List<Flight> flightList = flightRepository.findAll();
        System.out.println(flightList);

        //verificar la salida o el comportamiento
        assertThat(flightList).isNotNull();
        assertThat(flightList.size()).isEqualTo(2);
    }

    @Test
    void flightDeleteById(){
        flightRepository.save(flight);
        flightRepository.deleteById((flight.getId()));
        Optional<Flight> deletedFlight = flightRepository.findById(flight.getId());
        assertThat(deletedFlight).isEmpty();
    }

    @Test
    void flightUpdateTest(){
        flightRepository.save(flight);
        Flight flightBD = flightRepository.findById(flight.getId()).get();
        flightBD.setOrigin("Bra");
        flightBD.setDestiny("Arg");
        Flight flightUpdate = flightRepository.save(flightBD);
        assertThat(flightUpdate.getOrigin()).isEqualTo("Bra");
        assertThat(flightUpdate.getDestiny()).isEqualTo("Arg");


    }

}



