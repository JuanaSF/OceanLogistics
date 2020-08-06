package ar.com.ada.api.buques.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "puertos")
public class Puerto {

    private ObjectId _id;
    private Integer numero;
    private String nombre;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String get_id() {
        if (_id == null)
            return null;
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}