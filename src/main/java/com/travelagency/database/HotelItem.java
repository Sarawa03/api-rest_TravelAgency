package com.travelagency.database;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "hotels", catalog="travel_agency", schema="")
public class HotelItem {
	@Id
    @Column(name="idhotel")
    int idHotel;
    @Column
    String logo;
    @Column(name="hotelname")
    String hotelName;
    @Column
    String address;
    @Column
    String city;
    @Column
    String stars;
    @Column
    String website;
    @Column(name="bookedtimes")
    String bookedTimes;
    
    @OneToMany(targetEntity = RoomItem.class, cascade= CascadeType.ALL)
    @JoinColumn(name="hotel", referencedColumnName = "idhotel")
    List<RoomItem> rooms;
    //@OneToMany(mappedBy = "hotel")
    //@JsonManagedReference
    //List<RoomItem> rooms;
    
    public HotelItem() {
    }
    
    public HotelItem(int idhotel, String logo, String hotelname, String address, String city, String stars, String website, String bookedTimes, List<RoomItem> rooms) {
        this.idHotel = idhotel;
        this.logo = logo;
        this.hotelName = hotelname;
        this.address = address;
        this.city = city;
        this.stars = stars;
        this.website = website;
        this.bookedTimes = bookedTimes;
        this.rooms = rooms;
    }

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBookedTimes() {
		return bookedTimes;
	}

	public void setBookedTimes(String bookedTimes) {
		this.bookedTimes = bookedTimes;
	}

	public List<RoomItem> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomItem> rooms) {
		this.rooms = rooms;
	}
	
	

    
}
