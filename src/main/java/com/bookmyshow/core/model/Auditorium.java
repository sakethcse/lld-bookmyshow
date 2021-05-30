package com.bookmyshow.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "auditoriums")
public class Auditorium extends com.bookmyshow.core.model.Auditable {

  //attribs
  private String hallName;
  private boolean hasAirConditioner;
  private boolean canHost3D;
  private int numberOfEmergencyExits;
  private int numberOfExits;

  //relationships
  @ManyToOne
  private com.bookmyshow.core.model.Cinema cinema;

  @OneToMany(mappedBy = "auditorium")
  private List<AudiSeat> seats = new ArrayList<AudiSeat>();

  @OneToMany(mappedBy = "auditorium")
  private List<MovieShow> shows = new ArrayList<MovieShow>();

}