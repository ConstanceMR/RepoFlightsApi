package cac.vuelosapi2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor//genera constructor con todos los argumentos
@NoArgsConstructor//genera el constructor sin argumentos
@Data//genera getters y setters
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destiny;
    private String fechaHoraSalida;
    private String fechaHoraLlegada;
    private double price;
    private String frecuency;

    public Flight(String origin, String destiny, String fechaHoraSalida, String fechaHoraLlegada, double price, String frecuency) {
        this.origin = origin;
        this.destiny = destiny;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.price = price;
        this.frecuency = frecuency;
    }
}
