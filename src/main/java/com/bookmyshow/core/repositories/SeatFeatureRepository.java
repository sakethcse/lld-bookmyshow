package com.bookmyshow.core.repositories;

import com.bookmyshow.core.model.Movie;
import com.bookmyshow.core.model.SeatFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatFeatureRepository extends JpaRepository<SeatFeature,Long> {
}
