package com.bookmyshow.core.repositories;

import com.bookmyshow.core.model.Booking;
import com.bookmyshow.core.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
