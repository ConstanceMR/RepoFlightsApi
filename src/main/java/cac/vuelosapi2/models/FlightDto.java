package cac.vuelosapi2.models;

import lombok.Data;

@Data
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String fechaHoraSalida;
    private String fechaHoraLlegada;
    private double convertedPrice;
}
