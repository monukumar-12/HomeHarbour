package com.HomeHarbour.HomeHarbourApp.repository;

import com.HomeHarbour.HomeHarbourApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
