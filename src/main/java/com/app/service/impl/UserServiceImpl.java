package com.app.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.UserEntity;
import com.app.model.User;
import com.app.repo.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;

	@Override
	public boolean saveUser(User u) {
		UserEntity entity = new UserEntity();
		User user = new User();
		BeanUtils.copyProperties(u, entity);
		UserEntity save = repo.save(entity);
		return save != null;
	}

	@Override
	public String findByEmail(String email) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(email, entity);
		UserEntity findByUserEmail = repo.findByUserEmail(email);
		if (null != findByUserEmail) {
			return "Duplicate";
		}
		return "Unique";
	}

}
