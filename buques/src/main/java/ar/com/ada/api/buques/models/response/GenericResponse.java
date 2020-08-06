package ar.com.ada.api.buques.models.response;

public class GenericResponse {

    public boolean isOk;
    public String id; // Porque vamos a devolver los ObjectId en formato string
    public String message;
}