package com.cg.creditcardbillpayment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.UserRepository;
import com.cg.creditcardbillpayment.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepo;
	@Override
	public String signIn(String id, String password) {
		// TODO Auto-generated method stub
		
		String password1=userrepo.getById(id).getPassword();
		if (password1.equals(password)) {
			return "Success";
		}
		else {
			return "Failed";
		}
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changePassword(String id, User user) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public User CreateAccount(User user) {
		// TODO Auto-generated method stub
		userrepo.saveAndFlush(user);
		return user;
	}

}
