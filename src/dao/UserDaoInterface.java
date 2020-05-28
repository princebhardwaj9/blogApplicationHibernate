package dao;

import model.Users;

public interface UserDaoInterface {
	int signupUser(Users user);
	boolean loginUser(String email, String password);
}
