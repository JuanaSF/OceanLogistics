package ar.com.ada.api.buques.entities;

public class Contenedor {
    
    private Integer contenedorId;
    private Double peso;
    private Puerto puerto;

    public Integer getContenedorId() {
        return contenedorId;
    }

    public void setContenedorId(Integer contenedorId) {
        this.contenedorId = contenedorId;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Puerto getPuerto() {
        return puerto;
    }

    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }
}
