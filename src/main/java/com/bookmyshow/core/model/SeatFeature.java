package com.bookmyshow.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "seatfeatures")
public class SeatFeature extends Auditable {

  private String name;
  private String description;


  public SeatFeature() {
  }

  public SeatFeature(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
