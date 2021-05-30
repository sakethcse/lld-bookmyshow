package com.bookmyshow.core.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends Auditable {

  //attribs
  private String name;
  private String director;
  private MPAARating mpaaRating;
  private String language;
  private Date releaseDate;
  private int durationMinutes;
  private String summary;


  //relationships
  @OneToMany(mappedBy = "movie")
  private List<MovieShow> shows = new ArrayList<MovieShow>();

  @ManyToMany
  private List<Genre> genres = new ArrayList<Genre>();

  public Movie(String name, MPAARating mpaaRating) {
    this.name = name;
    this.mpaaRating = mpaaRating;
  }
}
