package com.bookmyshow.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre extends Auditable {

  //attrtibs
  private String name;
  private String description;


  //relationships
  @ManyToMany
  @Getter
  @Setter
  private List<Movie> movies = new ArrayList<Movie>();

  public Genre(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
