package cac.vuelosapi2.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightTest {
    private static Flight flight;

    @BeforeAll
    public static void setUp(){
        flight = new Flight();
    }
    @Test
    public void setAndGetOriginTest() {
        System.out.println("se esta creando el vuelo");
        String testedOrigin = "COR";
        flight.setOrigin(testedOrigin);
        System.out.println("se le asigna el origen: " + testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), (testedOrigin));
    }
    @Test
    public void setAndGetDestinyTest(){
        String testedDestiny = "EZE";
        flight.setDestiny(testedDestiny);
        Assertions.assertEquals(flight.getDestiny(), (testedDestiny));
    }
}
