package com.travelagency.database;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users", catalog="travel_agency", schema="")
public class UserItem {
	@Id
	@Column(name="iduser")
	int idUser;
	@Column
	String username;
	@Column
	String email;
	@Column(name="userpassword")
	String userPassword;
	@Column
	String phone;
	@Column
	String img;
	@Column
	String administrator;
	@Column(name="bookedtimes")
    String bookedTimes;
	@JoinTable(
    		name = "bookings",
    		joinColumns = @JoinColumn(name = "iduser", nullable= false),
    		inverseJoinColumns = @JoinColumn(name="idroom", nullable=false)
    )
    @ManyToMany
    List<RoomItem> rooms;
	
	public UserItem() {
		
	}
	
	

	public UserItem(int idUser, String username, String email, String userPassword, String phone, String img,String administrator, String bookedTimes, List<RoomItem> rooms) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.email = email;
		this.userPassword = userPassword;
		this.phone = phone;
		this.img = img;
		this.administrator = administrator;
		this.bookedTimes = bookedTimes;
		this.rooms = rooms;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getAdministrator() {
		return administrator;
	}



	public void setAdministrator(String administrator) {
		this.administrator = administrator;
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
