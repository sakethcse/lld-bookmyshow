package com.bookmyshow.core.repositories;

import com.bookmyshow.core.model.Coupon;
import com.bookmyshow.core.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {
}