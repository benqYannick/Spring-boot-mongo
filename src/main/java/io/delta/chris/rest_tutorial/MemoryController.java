package io.delta.chris.rest_tutorial;

import io.delta.chris.rest_tutorial.models.Memory;
import io.delta.chris.rest_tutorial.repositories.repositories;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/statistics/memoryUsage/")
public class MemoryController {
    @Autowired
    private repositories repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Memory> getAllMemory() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Memory getMemoryById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMemoryById(@PathVariable("id") ObjectId id, @Valid @RequestBody Memory memory) {
        memory.set_id(id);
        repository.save(memory);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Memory createMemory(@Valid @RequestBody Memory memory) {
        memory.set_id(ObjectId.get());
        repository.save(memory);
        return memory;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMemory(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}