package ar.com.ada.api.buques.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.ada.api.buques.entities.Puerto;

public interface PuertoRepository extends MongoRepository<Puerto, ObjectId> {

    Puerto findBy_id(ObjectId id);    
}