package ar.com.ada.api.buques.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buques")
public class Buque {

    private ObjectId _id;
    private String matricula;
    private String nombre;
    private List<Viaje> viajes = new ArrayList<>();

    public String get_id() {
        if (_id == null) {
            return null;
        }
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public void agregarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }

    public Viaje buscarViaje(Date fecha) {

        for (Viaje viaje : viajes) {
            if (viaje.getFechaViaje().equals(fecha)) {
                return viaje;
            }
        }
        return null;
    }
}