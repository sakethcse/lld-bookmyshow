package com.bookmyshow.core.model;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movies")
@EnableJpaAuditing
public class Movie extends Auditable {

  //attribs
  private String name;
  private String director;
  private MPAARating mpaaRating;
  private String summary;


  //relationships
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
  private List<MovieShow> shows = new ArrayList<MovieShow>();

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Genre> genres = new ArrayList<Genre>();

  public Movie(String name, MPAARating mpaaRating) {
    this.name = name;
    this.mpaaRating = mpaaRating;
  }


  public static final class Builder {
    private @NonNull String name;
    private MPAARating mpaaRating;
    private @NonNull String director;
    private @NonNull String summary;
    private List<MovieShow> shows;
    private List<Genre> genres;

    private Builder(String name, MPAARating mpaaRating) {
      this.name = name;
      this.mpaaRating = mpaaRating;
    }

    public static Builder aMovie(String name, MPAARating mpaaRating) {
      return new Builder(name, mpaaRating);
    }

    public Builder withDirector(String director) {
      this.director = director;
      return this;
    }

    public Builder withSummary(String summary) {
      this.summary = summary;
      return this;
    }

    public Builder withShows(List<MovieShow> shows) {
      this.shows = shows;
      return this;
    }

    public Builder withGenres(List<Genre> genres) {
      this.genres = genres;
      return this;
    }

    public Movie build() {
      Movie movie = new Movie(name, mpaaRating);
      movie.setDirector(director);
      movie.setSummary(summary);
      //movie.setShows(shows);
      //movie.setGenres(genres);
      return movie;
    }
  }
}
