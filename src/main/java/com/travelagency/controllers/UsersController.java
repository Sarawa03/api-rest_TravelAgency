package com.travelagency.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelagency.database.UserItem;
import com.travelagency.negocio.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	public List<UserItem> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	@GetMapping("/users/{user_id}")
    public UserItem getUserById(@PathVariable int user_id){
        return usersService.getUserById(user_id);
    }
	
	@PostMapping("/users")
	public void insert(@RequestBody UserItem us) {
		usersService.saveUser(us);
	}
	
	@DeleteMapping(value="/users/{user_id}")
	public void delete (@PathVariable Integer user_id) {
		usersService.deleteUser(user_id);
	}
	
	@PutMapping("/users")
	public UserItem modify (@RequestBody UserItem us) {
		return usersService.updateUser(us);
	}

}
