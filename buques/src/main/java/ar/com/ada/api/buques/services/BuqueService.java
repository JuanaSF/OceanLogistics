package ar.com.ada.api.buques.services;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buques.entities.Buque;
import ar.com.ada.api.buques.entities.Contenedor;
import ar.com.ada.api.buques.entities.Puerto;
import ar.com.ada.api.buques.entities.Viaje;
import ar.com.ada.api.buques.entities.Viaje.ResultadoEnum;
import ar.com.ada.api.buques.repos.BuqueRepository;

@Service
public class BuqueService {

    @Autowired
    BuqueRepository repo;
    @Autowired
    PuertoService puertoService;

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

	public ResultadoEnum cargarContenedor(String idBuque, Date fechaViaje, Integer contenedorId, Double peso,
            Integer numeroPuerto) {

        Contenedor contenedor = new Contenedor();
        contenedor.setContenedorId(contenedorId);
        contenedor.setPeso(peso);
        Puerto puerto = puertoService.buscarPorNumero(numeroPuerto);
        if(puerto == null)
            return ResultadoEnum.PUERTO_NO_ENCONTRADO;

        contenedor.setPuerto(puerto);
        Buque buque = repo.findBy_id(new ObjectId(idBuque));
        if(buque == null) 
            return ResultadoEnum.BUQUE_INEXISTENTE;
        
        Viaje viaje = buque.buscarViaje(fechaViaje);
        if(viaje == null)
            return ResultadoEnum.VIAJE_NO_ENCONTRADO;
        
        boolean resultado = viaje.agregarContenedor(contenedor);

        if (resultado) {
            repo.save(buque);
            return ResultadoEnum.CARGA_EXITOSA;
        }
        return ResultadoEnum.CARGA_MAXIMA_SUPERDA;
    }
    
}