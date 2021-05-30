package com.bookmyshow.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "movieshows")
public class MovieShow extends Auditable {

  //attribs
  private Date timingFrom;

  private Date timingTo;

  //relationships
  @OneToMany(mappedBy = "show")
  private List<Booking> bookings;

  @ManyToOne
  private Auditorium auditorium;

  @ManyToOne
  private Movie movie;

  public MovieShow(Date timingFrom, Date timingTo, Movie movie) {
    this.timingFrom = timingFrom;
    this.timingTo = timingTo;
    this.movie = movie;
  }
}
