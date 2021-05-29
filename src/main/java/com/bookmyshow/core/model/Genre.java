package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="genres")
public class Genre extends Auditable {

  //attrtibs
  private String name;
  private String description;


  //relationships
  @ManyToMany
  @Getter @Setter
  private List<Movie> movies = new ArrayList<Movie>();
}
