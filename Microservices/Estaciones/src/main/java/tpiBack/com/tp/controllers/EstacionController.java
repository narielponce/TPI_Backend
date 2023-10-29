package tpiBack.com.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpiBack.com.tp.dtos.AddNuevaEstacionDTO;
import tpiBack.com.tp.dtos.EstacionDTO;
import tpiBack.com.tp.services.EstacionService;

import java.util.List;

@RestController
class EstacionController {
    @Autowired
    EstacionService estacionService;

    @GetMapping (value = "api/estaciones")
    public ResponseEntity<List<EstacionDTO>> findAll() {
        List<EstacionDTO> estacionList = estacionService.findAll();
        return ResponseEntity.ok(estacionList);
    }

    @GetMapping(value = "api/estacion/{id}")
    public ResponseEntity<EstacionDTO> getTaskById(@PathVariable Long id){
        EstacionDTO estacion = estacionService.findById(id);

        if (estacion != null) {
            return ResponseEntity.ok(estacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/api/nuevaestacion")
    public ResponseEntity<AddNuevaEstacionDTO> createEstacion(@RequestBody AddNuevaEstacionDTO addNuevaEstacionDTO) {
        AddNuevaEstacionDTO createdEstacion = estacionService.save(addNuevaEstacionDTO);
        return ResponseEntity.ok(createdEstacion);
    }

    @GetMapping (value = "api/estacion" )
    public ResponseEntity<EstacionDTO> findNearestStation(@RequestParam double lat1, @RequestParam double lon1){
        EstacionDTO estacionDTO = estacionService.encontrarEstacionCercana(lat1, lon1);
        return ResponseEntity.ok(estacionDTO);
    }
}
