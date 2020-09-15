package org.ehrbase.numappbackend.opt.shareddefinition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum SymptomSignNameDefiningcode implements EnumValueSet {
  N315642008("315642008", "315642008", "SNOMED-CT", "315642008");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  SymptomSignNameDefiningcode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
     return this.value ;
  }

  public String getDescription() {
     return this.description ;
  }

  public String getTerminologyId() {
     return this.terminologyId ;
  }

  public String getCode() {
     return this.code ;
  }
}
