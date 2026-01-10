package com.HomeHarbour.HomeHarbourApp.service;

import com.HomeHarbour.HomeHarbourApp.dto.BookingDto;
import com.HomeHarbour.HomeHarbourApp.dto.BookingRequest;
import com.HomeHarbour.HomeHarbourApp.dto.GuestDto;
import com.HomeHarbour.HomeHarbourApp.entity.enums.BookingStatus;
import com.stripe.model.Event;

import java.util.List;
import java.util.Map;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);


    BookingStatus getBookingStatus(Long bookingId);
}
