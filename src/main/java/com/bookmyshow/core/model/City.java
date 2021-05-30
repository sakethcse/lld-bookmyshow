package com.bookmyshow.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City {

  //attribs
  private String name;
  private String state;
  private String country;

  //relationships
  @OneToMany
  private List<Cinema> cinemas = new ArrayList<Cinema>();

}
