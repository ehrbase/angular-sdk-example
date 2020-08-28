package org.ehrbase.numappbackend.controller;

import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.numappbackend.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.numappbackend.service.DiagnosisService;
import org.ehrbase.numappbackend.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class DiagnosisController {

    private final DiagnosisService service;
    private final ExampleService example;

    @Autowired
    public DiagnosisController(DiagnosisService service, ExampleService example) {
        this.service = service;
        this.example = example;
    }

    @PostMapping(path = "/ehr")
    public ResponseEntity<Map<String, UUID>> postEhr() {
        UUID ehrId = service.createEhr();
        return ResponseEntity.ok(Collections.singletonMap("ehr_id", ehrId));
    }

    @PostMapping(path = "/{ehr_id}/diagnosis")
    public ResponseEntity<VersionUid> postDiagnosis(
            @PathVariable(value = "ehr_id") UUID ehrId,
            @RequestBody DiagnoseComposition body) {
        VersionUid versionUid = service.saveDiagnosis(ehrId, body);
        return ResponseEntity.ok(versionUid);
    }

    @GetMapping(path = "/{ehr_id}/diagnosis/{id}")
    public ResponseEntity<DiagnoseComposition> getAssessment(
            @PathVariable(value = "ehr_id") UUID ehrId,
            @PathVariable(value = "id") VersionUid id) {
        Optional<DiagnoseComposition> composition = service.getAssessment(ehrId, id);

        return composition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // EXAMPLE section

    @GetMapping(path = "/example/diagnosis")
    public ResponseEntity<DiagnoseComposition> getExample() {
        return ResponseEntity.of(example.createExample());
    }
}
