package ar.com.ada.api.buques.controllers;

import ar.com.ada.api.buques.entities.Puerto;
import ar.com.ada.api.buques.models.response.GenericResponse;
import ar.com.ada.api.buques.services.PuertoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PuertoController {

    @Autowired
    PuertoService puertoService;

    @PostMapping("/puertos")
    public ResponseEntity<GenericResponse> crearPuerto(@RequestBody Puerto puerto) {

        boolean creacionOk;
        creacionOk = puertoService.crearPuerto(puerto);

        GenericResponse resp = new GenericResponse();

        if (creacionOk) {

            resp.isOk = true;
            resp.id = puerto.get_id();
            resp.message = "Se creo el Puerto con exito!";

            return ResponseEntity.ok(resp);
        }

        resp.isOk = false;
        resp.message = "No se pudo crear";
        return ResponseEntity.badRequest().body(resp);
    }

    @GetMapping("/puertos")
    public ResponseEntity<List<Puerto>> listarPuertos() {
        
        List<Puerto> listaPuertos = puertoService.listarPuertos();

        return ResponseEntity.ok(listaPuertos);
    }

}