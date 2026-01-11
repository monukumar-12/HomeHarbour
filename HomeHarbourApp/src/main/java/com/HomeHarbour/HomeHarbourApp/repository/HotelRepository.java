package com.HomeHarbour.HomeHarbourApp.repository;

import com.HomeHarbour.HomeHarbourApp.entity.Hotel;
import com.HomeHarbour.HomeHarbourApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByOwner(User user);
}
