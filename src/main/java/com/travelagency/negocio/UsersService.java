package com.travelagency.negocio;

import java.util.List;
import com.travelagency.database.UserItem;

public interface UsersService {
	List<UserItem> getAllUsers();
	UserItem getUserById(int user_id);

	UserItem saveUser(UserItem us);
	void deleteUser(int user_id);
	
	UserItem updateUser(UserItem us);
}
