package com.spring.booking.repository;

import com.spring.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   // void findAll(LocalDate checkIn, LocalDate checkOut);//
}

