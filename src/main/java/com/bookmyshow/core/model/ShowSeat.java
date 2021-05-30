package com.bookmyshow.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "showseats")
public class ShowSeat extends Auditable {


  @ManyToOne
  private Booking booking;

  @ManyToOne
  private MovieShow show;

  private ShowSeatStatus status = ShowSeatStatus.AVAILABLE;

  private double price;

  private ShowSeat(MovieShow show, double price) {
    this.show = show;
    this.price = price;
  }

}
