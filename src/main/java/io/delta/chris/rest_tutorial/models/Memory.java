package io.delta.chris.rest_tutorial.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Memory {
    @Id
    public ObjectId _id;
    public String memoryUsage;

    // Constructors
    public Memory() {}

    public Memory(ObjectId _id, String memoryUsage) {
        this._id = _id;
        this.memoryUsage = memoryUsage;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getMemoryUsage() { return memoryUsage; }
    public void setMemoryUsage(String memoryUsage) { this.memoryUsage = memoryUsage; }
}