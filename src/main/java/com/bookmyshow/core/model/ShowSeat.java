package com.bookmyshow.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "showseats")
public class ShowSeat extends Auditable {



  //ralationships
  @ManyToOne
  private Booking booking;

  @ManyToOne
  private MovieShow show;

  @ManyToOne
  private AudiSeat audiSeat;

  private ShowSeatStatus status = ShowSeatStatus.AVAILABLE;

  private double price;

  private ShowSeat(MovieShow show, double price) {
    this.show = show;
    this.price = price;
  }

}
