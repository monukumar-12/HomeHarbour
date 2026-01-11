package com.HomeHarbour.HomeHarbourApp.repository;

import com.HomeHarbour.HomeHarbourApp.entity.Booking;
import com.HomeHarbour.HomeHarbourApp.entity.Hotel;
import com.HomeHarbour.HomeHarbourApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByPaymentSessionId(String paymentSessionId);

    List<Booking> findByHotel(Hotel hotel);

    List<Booking> findByHotelAndCreatedAtBetween(Hotel hotel, LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Booking> findByUser(User user);
}
