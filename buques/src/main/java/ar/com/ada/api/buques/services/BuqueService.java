package ar.com.ada.api.buques.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Buque;
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
    
}