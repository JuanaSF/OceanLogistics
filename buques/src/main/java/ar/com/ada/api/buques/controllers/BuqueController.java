package ar.com.ada.api.buques.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.buques.entities.Buque;
import ar.com.ada.api.buques.models.request.ViajeRequest;
import ar.com.ada.api.buques.models.response.GenericResponse;
import ar.com.ada.api.buques.services.BuqueService;

@RestController
public class BuqueController {

    @Autowired
    BuqueService buqueService;

    @PostMapping("/buques")
    public ResponseEntity<GenericResponse> crearBuque(@RequestBody Buque buque){

        boolean resultado = buqueService.crearBuque(buque);
        GenericResponse resp = new GenericResponse();

        if(resultado) {
            resp.isOk = true;
            resp.id = buque.get_id();
            resp.message = "Se creo buque correctamente";

            return ResponseEntity.ok(resp);
        }
        resp.isOk = false;
        resp.message = "no se pudo crear el buque";

        return ResponseEntity.badRequest().body(resp);
    }

    @GetMapping("/buques")
    public ResponseEntity<List<Buque>> listarBuques() {

        List<Buque> listaBuques = buqueService.listarBuques();

        return ResponseEntity.ok(listaBuques);
    }

    @PostMapping("/buques/{id}/viajes")
    public ResponseEntity<GenericResponse> crearViaje(@PathVariable String id, @RequestBody ViajeRequest infoViaje) {

        boolean resultado = buqueService.crearViaje(id, infoViaje.fechaViaje, infoViaje.fechaSalida,
                infoViaje.fechaLlegada);
        GenericResponse resp = new GenericResponse();

        if (resultado) {
            resp.isOk = true;
            resp.message = "El viaje se grabo correctamente";
            return ResponseEntity.ok(resp);
        }

        resp.isOk = false;
        resp.message = "No se pudo grabar el viaje";
        return ResponseEntity.badRequest().body(resp);
    }
    
}