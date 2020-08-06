package ar.com.ada.api.buques.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.buques.entities.Puerto;

@Repository
public interface PuertoRepository extends MongoRepository<Puerto, ObjectId> {

    Puerto findBy_id(ObjectId id);    
    Puerto findByNumero(Integer numero);
}