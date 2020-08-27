package org.ehrbase.numappbackend;

import java.io.InputStream;
import java.util.Arrays;

public enum OperationalTemplateData {

    DIAGNOSE("Diagnose", "Diagnose.v1.opt", "Diagnose");

    private final String filename;
    private final String templateId;
    private final String description;

    OperationalTemplateData(String description, String filename, String templateId) {
        this.filename = filename;
        this.description = description;
        this.templateId = templateId;
    }

    public InputStream getStream() {
        return getClass().getResourceAsStream("/opt/" + filename);
    }

    public static OperationalTemplateData findByTemplateId(String templateId) {
        return Arrays.stream(OperationalTemplateData.values())
                .filter(o -> o.getTemplateId().equals(templateId))
                .findAny()
                .orElse(null);
    }

    public String getTemplateId() {
        return templateId;
    }
}
