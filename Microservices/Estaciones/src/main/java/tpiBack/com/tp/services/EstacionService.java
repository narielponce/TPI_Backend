package tpiBack.com.tp.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpiBack.com.tp.dtos.AddNuevaEstacionDTO;
import tpiBack.com.tp.dtos.EstacionDTO;
import tpiBack.com.tp.models.Estacion;
import tpiBack.com.tp.repositories.EstacionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EstacionService {

    @Autowired
    EstacionRepository estacionRepository;

    public List<EstacionDTO> findAll(){
        List<Estacion> estacionList = estacionRepository.findAll();
        return estacionList.stream().map(this::convertToDtoLista).collect(Collectors.toList());
    }

    public EstacionDTO findById(Long id) {
        Optional<Estacion> estacion = estacionRepository.findById(id);
        return estacion.map(this::convertToDtoLista).orElse(null);
    }

    public AddNuevaEstacionDTO save(AddNuevaEstacionDTO addNuevaEstacionDTO){
        Estacion estacion = convertToEntity(addNuevaEstacionDTO);
        Estacion savedEstacion = estacionRepository.save(estacion);
        return convertToDtoCarga(savedEstacion);
    }

    public EstacionDTO encontrarEstacionCercana(double lat1, double lon1){

        List<Estacion> estacions = estacionRepository.findAll();
        //------------------------------------------------------
        Estacion estacionCercana = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (Estacion estacion : estacions) {
            double distancia = DistanciaEntrePuntos.calcularDistanciaHaversine(lat1, lon1, estacion.getLatitud(), estacion.getLongitud());
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                estacionCercana = estacion;
            }
        }
        return convertToDtoLista(estacionCercana);
    }

    public EstacionDTO convertToDtoLista(@NotNull Estacion estacion){
        EstacionDTO estacionDTO = new EstacionDTO();

        estacionDTO.setEstacionId(estacion.getId());
        estacionDTO.setNombre(estacion.getNombre());

        return estacionDTO;
    }

    public AddNuevaEstacionDTO convertToDtoCarga(@NotNull Estacion estacion) {
        AddNuevaEstacionDTO addNuevaEstacionDTO = new AddNuevaEstacionDTO();

        addNuevaEstacionDTO.setNombre(estacion.getNombre());
        addNuevaEstacionDTO.setLatitud(estacion.getLatitud());
        addNuevaEstacionDTO.setLongitud(estacion.getLongitud());

        return addNuevaEstacionDTO;
    }

    public Estacion convertToEntity(@NotNull AddNuevaEstacionDTO addNuevaEstacionDTO){
        Estacion estacion = new Estacion();

        LocalDateTime horaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);

        estacion.setNombre(addNuevaEstacionDTO.getNombre());
        estacion.setFechaHoraCreacion(horaFormateada);
        estacion.setLatitud(addNuevaEstacionDTO.getLatitud());
        estacion.setLongitud(addNuevaEstacionDTO.getLongitud());

        return estacion;
    }

}
