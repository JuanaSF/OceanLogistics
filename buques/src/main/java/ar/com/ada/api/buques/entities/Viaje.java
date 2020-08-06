package ar.com.ada.api.buques.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Viaje {

    private Date fechaViaje;
    private Date fechaSalida;
    private Date fechaLlegada;
    private List<Contenedor> contenedores = new ArrayList<>();

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public List<Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public boolean agregarContenedor(Contenedor contenedor) {
        
        if (contenedores.size() > 100) {
            return false;
        }
        contenedores.add(contenedor);
        return true;
    }

}