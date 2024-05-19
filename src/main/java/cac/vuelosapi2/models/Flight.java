package cac.vuelosapi2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destiny;
    private String departureDate;
    private String arrivingDate;
    private double price;
    private String frecuency;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Flight(String origin, String destiny, String departureDate, String arrivingDate, double price, String frecuency) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDate = departureDate;
        this.arrivingDate = arrivingDate;
        this.price = price;
        this.frecuency = frecuency;
    }
}
