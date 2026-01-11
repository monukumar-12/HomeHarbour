package com.HomeHarbour.HomeHarbourApp.controller;


import com.HomeHarbour.HomeHarbourApp.dto.HotelDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelInfoDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelPriceDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelSearchRequest;
import com.HomeHarbour.HomeHarbourApp.service.HotelService;
import com.HomeHarbour.HomeHarbourApp.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    @Operation(summary = "Search hotels", tags = {"Browse Hotels"})
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {

     var page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    @Operation(summary = "Get a hotel info by hotelId", tags = {"Browse Hotels"})
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }

}
