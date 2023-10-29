package tpiBack.com.tp.dtos;

import lombok.Data;

@Data
public class AddNuevaEstacionDTO {
    private String nombre;
    private double latitud;
    private double longitud;
}
