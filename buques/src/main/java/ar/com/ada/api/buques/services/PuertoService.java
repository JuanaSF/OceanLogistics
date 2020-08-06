package ar.com.ada.api.buques.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Puerto;
import ar.com.ada.api.buques.repos.PuertoRepository;

@Service
public class PuertoService {
    
    @Autowired 
    PuertoRepository repo;

    public boolean crearPuerto(Puerto puerto){
        this.guardar(puerto);
        
        if (puerto.get_id() == null) {

            return false;
        }
        return true;
    }

    public void guardar(Puerto puerto){
        repo.save(puerto);
    }

    public List<Puerto> listarPuertos() {
        return repo.findAll();
    }
}