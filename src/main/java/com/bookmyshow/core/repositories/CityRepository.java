package com.bookmyshow.core.repositories;

import com.bookmyshow.core.model.City;
import com.bookmyshow.core.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
