package tpiBack.com.tp.dtos;

import lombok.Data;

@Data
public class FindNearestStationDTO {
    private double latitudeClient;
    private double longitudeClient;
}
