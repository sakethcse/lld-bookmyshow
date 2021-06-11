package com.bookmyshow.core.repositories;

import com.bookmyshow.core.model.Movie;
import com.bookmyshow.core.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow,Long> {
}
