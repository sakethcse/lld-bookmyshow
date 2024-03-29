package com.bookmyshow.core.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "roles")
public class Role extends Auditable {


  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  public Role() {
  }

  public Role(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
