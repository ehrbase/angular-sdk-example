package org.ehrbase.numappbackend.controller;

import org.ehrbase.numappbackend.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosisController {

    private final ExampleService example;

    @Autowired
    public DiagnosisController(ExampleService example) {
        this.example = example;
    }

    @GetMapping(path = "/example/diagnosis")
    public ResponseEntity getExample() {
        return ResponseEntity.noContent().build();
    }
}
