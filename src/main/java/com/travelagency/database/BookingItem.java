package com.travelagency.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings", catalog="travel_agency", schema="")
public class BookingItem {
	@Id
    @Column (name="idbooking")
    int idBooking;
    @Column (name="iduser")
    String idUser;
    @Column (name="idroom")
    String idRoom;
    @Column (name="startdate")
    String initialDate;
    @Column (name="enddate")
    String endDate;
    
    
    
    public BookingItem() {
    }

    public BookingItem(int idbooking, String iduser, String idroom, String initialDate, String endDate) {
        this.idBooking = idbooking;
        this.idUser = iduser;
        this.idRoom = idroom;
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    public int getIdbooking() {
        return idBooking;
    }



    public void setIdbooking(int idbooking) {
        this.idBooking = idbooking;
    }



    public String getIduser() {
        return idUser;
    }



    public void setIduser(String iduser) {
        this.idUser = iduser;
    }



    public String getIdroom() {
        return idRoom;
    }



    public void setIdroom(String idroom) {
        this.idRoom = idroom;
    }



    public String getInitialDate() {
        return initialDate;
    }



    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }



    public String getEndDate() {
        return endDate;
    }



    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
