package com.HomeHarbour.HomeHarbourApp.service;
import com.HomeHarbour.HomeHarbourApp.dto.HotelDto;
import com.HomeHarbour.HomeHarbourApp.dto.HotelInfoDto;
import com.HomeHarbour.HomeHarbourApp.dto.RoomDto;
import com.HomeHarbour.HomeHarbourApp.entity.Hotel;
import com.HomeHarbour.HomeHarbourApp.entity.Inventory;
import com.HomeHarbour.HomeHarbourApp.entity.Room;
import com.HomeHarbour.HomeHarbourApp.entity.User;
import com.HomeHarbour.HomeHarbourApp.exception.ResourceNotFoundException;
import com.HomeHarbour.HomeHarbourApp.exception.UnAuthorisedException;
import com.HomeHarbour.HomeHarbourApp.repository.HotelRepository;
import com.HomeHarbour.HomeHarbourApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class HotelServiceImplementation implements HotelService{

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    private final InventoryService inventoryService;

    private final RoomRepository roomRepository;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("creating a new hotel with name: {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
  User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  hotel.setOwner( user);

        hotel= hotelRepository.save(hotel);
        log.info("created a new hotel with id: {}",hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("getting a hotel by id : {}", id);

      Hotel hotel=   hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found with id :"+  id));

        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user.equals(hotel.getOwner())){
            throw new UnAuthorisedException("This user does not own this hotel with id: "+ id);
        }

        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("updating hotel with ID :{} ", id);

        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Not found with id: "+id));

        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user.equals(hotel.getOwner())){
            throw new UnAuthorisedException("This user does not own this hotel with id: "+ id);
        }

        modelMapper.map(hotelDto,hotel);
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);

        return modelMapper.map(hotel,HotelDto.class);

    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));

        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user.equals(hotel.getOwner())){
            throw new UnAuthorisedException("This user does not own this hotel with id: "+ id);
        }


        for(Room room: hotel.getRooms()) {
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }
        hotelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user.equals(hotel.getOwner())){
            throw new UnAuthorisedException("This user does not own this hotel with id: "+ hotelId);
        }

        hotel.setActive(true);

        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
    }


    @Override

    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));


        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }
}
