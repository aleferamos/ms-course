package com.aleferamos.hrworker.resources;

import com.aleferamos.hrworker.entities.Worker;
import com.aleferamos.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResorce {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok().body(workerRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(workerRepository.findById(id).get());
    }
}
