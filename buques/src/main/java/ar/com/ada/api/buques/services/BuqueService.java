package ar.com.ada.api.buques.services;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Buque;
import ar.com.ada.api.buques.entities.Viaje;
import ar.com.ada.api.buques.repos.BuqueRepository;

@Service
public class BuqueService {

    @Autowired
    BuqueRepository repo;

    public boolean crearBuque(Buque buque) {
        guardar(buque);

        if (buque.get_id() == null) {
            return false;
        }
        return true;
    }

    public void guardar(Buque buque) {
        repo.save(buque);
    }

    public List<Buque> listarBuques() {
        return repo.findAll();
    }

    public boolean crearViaje(String id, Date fechaViaje, Date fechaSalida, Date fechaLlegada) {

        Viaje viaje = new Viaje();
        Buque buque = repo.findBy_id(new ObjectId(id));

        viaje.setFechaLlegada(fechaLlegada);
        viaje.setFechaSalida(fechaSalida);
        viaje.setFechaViaje(fechaViaje);

        buque.agregarViaje(viaje);
        repo.save(buque);
        return true;
    }
    
}