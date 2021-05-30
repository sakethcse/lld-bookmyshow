package com.bookmyshow.core.model;


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
@Table(name = "bookings")
public class Booking extends Auditable {

  //attribs
  private double totalPrice = 0;


  //relationships
  @ManyToOne
  private MovieShow show;

  @OneToMany
  private List<ShowSeat> seats = new ArrayList<ShowSeat>();

  @OneToMany
  private List<Transaction> transactions = new ArrayList<Transaction>();

  @ManyToOne
  private Coupon coupon;

  @ManyToOne
  private User user;

  public Booking(MovieShow show, User user) {
    this.show = show;
    this.user = user;
  }
}
