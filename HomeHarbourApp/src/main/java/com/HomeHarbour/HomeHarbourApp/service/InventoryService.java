package com.HomeHarbour.HomeHarbourApp.service;

import com.HomeHarbour.HomeHarbourApp.dto.*;
import com.HomeHarbour.HomeHarbourApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);
    void deleteAllInventories(Room room);


    Page<HotelPriceDto> searchHotels(HotelSearchRequest  hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
