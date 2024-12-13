package tn.projetdemo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInter {

	@Autowired
	UserRepository userRep;


	@Override
	public User addUser(User user) {

		return userRep.save(user);

	}


	@Override
	public List<User> addListUser(List<User> listuser) {
		return userRep.saveAll(listuser);
	}





	@Override
	public User updateUser(Long id, User user) {
		Optional<User> optionalUser = userRep.findById(id);
		if (optionalUser.isPresent()) {

			return userRep.save(user);
		} else {
			throw new RuntimeException("User with id " + id + " not found");
		}
	}

	@Override
	public void deleteUser(Long iduser) {
		userRep.deleteById(iduser);
	}


	@Override
	public List<User> getListUsers() {
		return userRep.findAll();
	}




	@Override
	public Optional<User> getUserById(Long id) {
		return userRep.findById(id);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = userRep.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}


