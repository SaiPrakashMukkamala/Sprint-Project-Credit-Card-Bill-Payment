package com.cg.creditcardbillpayment.services;

import com.cg.creditcardbillpayment.entities.User;

public interface UserService {
	public String signIn(String id,String password);

	public User signOut(User user);

	public User changePassword(String id, User user);
	
	public User CreateAccount(User user);
}
