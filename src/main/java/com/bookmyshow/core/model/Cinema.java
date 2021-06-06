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

  public Cinema(City city,String name) {
    this.name = name;
    this.city = city;
  }

  public static final class Builder {
    private City city;
    private String name;
    private String address;
    private List<Auditorium> halls;
    private boolean hasParking;

    private Builder(City city, String name) {
      this.city = city;
      this.name = name;
    }

    public static Builder aCinema(City city, String name) {
      return new Builder(city, name);
    }

    public Builder withAddress(String address) {
      this.address = address;
      return this;
    }

    public Builder withHalls(List<Auditorium> halls) {
      this.halls = halls;
      return this;
    }

    public Builder withHasParking(boolean hasParking) {
      this.hasParking = hasParking;
      return this;
    }

    public Cinema build() {
      Cinema cinema = new Cinema(city, name);
      cinema.setAddress(address);
      cinema.setHalls(halls);
      cinema.setHasParking(hasParking);
      return cinema;
    }
  }
}
