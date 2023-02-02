package com.spring.booking.repository;

import com.spring.booking.model.Hotel;
import com.spring.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    //List<Room> findAllContaining(LocalDate checkIn, LocalDate checkOut);//

}
