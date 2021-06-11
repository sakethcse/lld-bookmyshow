package com.bookmyshow.core.controller;


import com.bookmyshow.core.model.AudiSeat;
import com.bookmyshow.core.model.Auditorium;
import com.bookmyshow.core.model.Cinema;
import com.bookmyshow.core.model.City;
import com.bookmyshow.core.model.MPAARating;
import com.bookmyshow.core.model.Movie;
import com.bookmyshow.core.model.MovieShow;
import com.bookmyshow.core.model.Profile;
import com.bookmyshow.core.model.Role;
import com.bookmyshow.core.model.User;
import com.bookmyshow.core.repositories.AudiSeatRepository;
import com.bookmyshow.core.repositories.AuditoriumRepository;
import com.bookmyshow.core.repositories.CinemaRepository;
import com.bookmyshow.core.repositories.CityRepository;
import com.bookmyshow.core.repositories.MovieRepository;
import com.bookmyshow.core.repositories.MovieShowRepository;
import com.bookmyshow.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("db-init")
public class DBInitController {


  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private UserRepository userRepository;


  @Autowired
  private AudiSeatRepository audiSeatRepository;

  @Autowired
  private MovieShowRepository movieShowRepository;

  @Autowired
  private AuditoriumRepository auditoriumRepository;

  @Autowired
  private CityRepository cityRepository;


  @Autowired
  private CinemaRepository cinemaRepository;

  @GetMapping("generate")
  public String initDB(){

    movieRepository.deleteAll();

    //add a movie
    Movie movie = Movie.Builder.aMovie("bahubali", MPAARating.GeneralAudience).withDirector("rajamouli").withSummary("TeluguMovie").build();

    movieRepository.save(movie);

    //add a user
    User user = new User();
    user.setEmail("saketh.vadlamudi@gmail.com");
    user.setSaltedHashedPassword("saketh");

    Role role = new Role("user","customer");
    Set<Role> roles = new HashSet<>();
    roles.add(role);

    user.setRoles(roles);

    Profile profile = new Profile("saketh",user);
    user.setProfile(profile);

    userRepository.save(user);



    //add auditorium

    //get audiseats
    AudiSeat audiSeat = new AudiSeat("1","A");
    AudiSeat audiSeat2 = new AudiSeat("1","B");
    audiSeatRepository.save(audiSeat);
    audiSeatRepository.save(audiSeat2);

    List<AudiSeat> audiSeats = new ArrayList<>();
    audiSeats.add(audiSeat);
    audiSeats.add(audiSeat2);

    //get movie shows
    MovieShow movieShow = new MovieShow(new Date(), new Date(),movie);
    movieShowRepository.save(movieShow);


    List<MovieShow> movieShows = new ArrayList<>();
    movieShows.add(movieShow);


    Auditorium auditorium = Auditorium.Builder.aCinemaHall("pvr")
                                        .withHasAirConditioner(true)
                                        .withCanHost3D(true)
                                        .withNumberOfExits(8)
                                        .withNumberOfEmergencyExits(6)
                                        .withSeats(audiSeats)
                                        .withShows(movieShows)
                                         .build();
    auditoriumRepository.save(auditorium);
    ///////////////////////////////////////////////////////////////////////////

    //add a cinema (pvr)

    City city = new City("guntur","andhra","india",null);
    cityRepository.save(city);


    List<Auditorium> auditoriums = new ArrayList<>();
    auditoriums.add(auditorium);

    Cinema cinema = Cinema.Builder.aCinema(city,"guntur")
                                  .withAddress("brodipet")
                                  .withHalls(auditoriums)
                                  .withHasParking(true)
                                  .build();
    cinemaRepository.save(cinema);





    return "success";
  }
}
