package com.spring.booking.controller;

import com.spring.booking.exceptions.RoomNotFoundException;
import com.spring.booking.model.Room;
import com.spring.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;


    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add/{hotelId}")
    public Room addRoom(@RequestBody Room room, @PathVariable Long hotelId) {
        return roomService.addRoom(room, hotelId);
    }

    @DeleteMapping("/delete/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @GetMapping("/findAllRooms/{hotelId}")
    public List<Room> findAllRoomsByHotel(@PathVariable Long hotelId) {
        return roomService.findAllRoomsByHotel(hotelId);
    }

    @PutMapping("/update/{roomId}/{newPrice}")
    public Room updateRoomPrice(@PathVariable Long roomId, @PathVariable Integer newPrice) {
        return roomService.updateRoomPrice(roomId, newPrice);

       /* try {
            return roomService.updateRoomPrice(roomId, newPrice);
        } catch (RoomNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "room not found", e);
        }*/
    }
}
