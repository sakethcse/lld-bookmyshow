package com.bookmyshow.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "audiseats")
public class AudiSeat extends Auditable {

  //attribs
  private String rowNumber;
  private String seatNumber;

  //relationships
  @OneToMany(mappedBy = "audiSeat")
  List<ShowSeat> showSeats = new ArrayList<ShowSeat>();

  @ManyToOne
  private Auditorium auditorium;

  @ManyToMany
  private List<SeatFeature> features = new ArrayList<SeatFeature>();


  public AudiSeat(String rowNumber, String seatNumber) {
    this.rowNumber = rowNumber;
    this.seatNumber = seatNumber;
  }
}
