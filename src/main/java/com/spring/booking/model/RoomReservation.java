package com.spring.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RoomReservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "room-roomreservation")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JsonBackReference(value = "reservation-roomreservation")
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column
    private LocalDateTime dateCreated;

    public RoomReservation(){}

    public RoomReservation(Long id, Room room, Reservation reservation, LocalDateTime dateCreated) {
        this.id = id;
        this.room = room;
        this.reservation = reservation;
        this.dateCreated = dateCreated;
    }


    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
