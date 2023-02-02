package com.spring.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String roomNo;

    @Column
    private Integer price;

    @Column
    private Integer noOfPerson;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference(value = "room-roomreservation")
    private List<RoomReservation> roomReservationList;

    @ManyToOne
    @JsonBackReference(value="hotel-room")
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    public Room() {}

    public Room(Long id, String roomNo, Integer price, Integer noOfPerson, List<RoomReservation> roomReservationList, Hotel hotel) {
        this.id = id;
        this.roomNo = roomNo;
        this.price = price;
        this.noOfPerson = noOfPerson;
        this.roomReservationList = roomReservationList;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public List<RoomReservation> getRoomReservationList() {
        return roomReservationList;
    }

    public void setRoomReservationList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
