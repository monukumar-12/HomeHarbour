package com.HomeHarbour.HomeHarbourApp.service;

import com.HomeHarbour.HomeHarbourApp.dto.HotelDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelPriceDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelSearchRequest;
import com.HomeHarbour.HomeHarbourApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);
    void deleteAllInventories(Room room);


    Page<HotelPriceDto> searchHotels(HotelSearchRequest  hotelSearchRequest);
}
