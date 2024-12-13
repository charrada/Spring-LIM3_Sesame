package tn.projetdemo.demo.services;

import java.util.List;
import java.util.Optional;

import tn.projetdemo.demo.entities.User;

public interface UserServiceInter {

	public User addUser(User user);
	public List<User> addListUser(List<User> listuser);
	


	public User updateUser(Long iduser, User user);
	public void deleteUser(Long iduser);
	
	public List<User> getListUsers();
	



	Optional<User> getUserById(Long id);


	User getUserByUsernameAndPassword(String username, String password);
}
