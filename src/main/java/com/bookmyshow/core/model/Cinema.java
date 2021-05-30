package com.bookmyshow.core.model;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "cinemas")
public class Cinema extends Auditable {
  //attribs
  private boolean hasParking = true;

  @NotNull
  private String address;

  @NotNull
  private String name;


  //relationships
  @ManyToOne
  private City city;

  @OneToMany(mappedBy = "cinema")
  private List<Auditorium> halls = new ArrayList<Auditorium>();

  public Cinema(String name, City city) {
    this.name = name;
    this.city = city;
  }
}
