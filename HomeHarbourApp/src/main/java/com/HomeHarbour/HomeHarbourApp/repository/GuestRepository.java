package com.HomeHarbour.HomeHarbourApp.repository;

import com.HomeHarbour.HomeHarbourApp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}