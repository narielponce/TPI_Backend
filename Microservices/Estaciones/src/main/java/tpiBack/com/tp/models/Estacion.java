package tpiBack.com.tp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ESTACIONES")
@Data
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name = "FECHA_HORA_CREACION")
    private String fechaHoraCreacion;

    @Column(name = "LATITUD")
    private double latitud;

    @Column(name = "LONGITUD")
    private double longitud;
}
