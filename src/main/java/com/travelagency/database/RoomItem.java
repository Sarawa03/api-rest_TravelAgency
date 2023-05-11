package com.travelagency.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "rooms", catalog="travel_agency", schema="")
public class RoomItem {
	@Id
    @Column(name="idroom")
    int idRoom;
    @Column
    String price;
    @Column
    String capacity;
    @Column
    String booked;
    @Column
    String hotel;
    
    //@ManyToOne
    //@JoinColumn(name="hotel")
    //@JsonBackReference
    //HotelItem hotel;
    
    public RoomItem() {
        
    }
    
    public RoomItem(int idroom, String price, String capacity, String booked, String hotel) {
        this.idRoom = idroom;
        this.price = price;
        this.capacity = capacity;
        this.booked = booked;
        this.hotel = hotel;
    }

    public int getIdroom() {
        return idRoom;
    }

    public void setIdroom(int idroom) {
        this.idRoom = idroom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
}
