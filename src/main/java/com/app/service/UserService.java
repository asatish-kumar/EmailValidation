package com.app.service;

import com.app.model.User;

public interface UserService {
	public boolean saveUser(User u);
	public String findByEmail(String email);
}
