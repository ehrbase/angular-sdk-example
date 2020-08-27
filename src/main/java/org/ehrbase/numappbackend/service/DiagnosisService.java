package org.ehrbase.numappbackend.service;

import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.numappbackend.opt.diagnosecomposition.DiagnoseComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiagnosisService {

    private final DefaultRestClient client;

    @Autowired
    public DiagnosisService(DefaultRestClient client) {
        this.client = client;
    }

    public UUID createEhr() {
        return client.ehrEndpoint().createEhr();
    }

    public VersionUid saveDiagnosis(UUID ehrId, DiagnoseComposition composition) {
        client.compositionEndpoint(ehrId).mergeCompositionEntity(composition);
        return composition.getVersionUid();
    }
}
