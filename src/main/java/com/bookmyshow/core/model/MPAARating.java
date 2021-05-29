package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

public enum  MPAARating {

  GeneralAudience("G"),
  ParentalGuidenceSuggested("PG"),
  ParentsStronglyCautioned("PG-13"),
  Restrcietd("R"),
  AudultsOnly("NC-17");


  @Getter
  private String code;
  MPAARating(String code) {
    this.code = code;
  }
}
