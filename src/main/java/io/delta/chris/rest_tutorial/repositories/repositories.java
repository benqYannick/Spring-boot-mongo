package io.delta.chris.rest_tutorial.repositories;

import io.delta.chris.rest_tutorial.models.Memory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface repositories extends MongoRepository<Memory, String> {
    Memory findBy_id(ObjectId _id);
}