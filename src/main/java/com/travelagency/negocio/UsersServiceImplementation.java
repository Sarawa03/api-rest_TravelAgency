package com.travelagency.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.database.UserItem;
import com.travelagency.database.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public List<UserItem> getAllUsers(){
		return usersRepository.findAll();
	}
	
	@Override
	public UserItem getUserById(int user_id) {
		return usersRepository.findById(user_id).orElseThrow(()-> new RuntimeException("No data!"));
	}
	
	
	@Override
	public UserItem saveUser(UserItem us) {
		return usersRepository.save(us);
	}
	
	@Override
	public void deleteUser(int user_id) {
		usersRepository.deleteById(user_id);
	}
	
	@Override
	public UserItem updateUser(UserItem us) {
		UserItem userItem = usersRepository.findById(us.getIdUser()).orElseThrow(() -> new RuntimeException("No data!"));
		userItem.setUsername(us.getUsername());
		userItem.setEmail(us.getEmail());
		userItem.setUserPassword(us.getUserPassword());
		userItem.setPhone(us.getPhone());
		userItem.setImg(us.getImg());
		userItem.setAdministrator(us.getAdministrator());
		userItem.setBookedTimes(us.getBookedTimes());
		userItem.setRooms(us.getRooms());
		usersRepository.save(userItem);
		return userItem;
	}
	

}
