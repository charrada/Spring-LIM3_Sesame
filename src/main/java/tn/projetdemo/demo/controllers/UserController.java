package tn.projetdemo.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.projetdemo.demo.entities.User;
import tn.projetdemo.demo.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

	@Autowired
	UserServiceImpl userServ;


	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userServ.addUser(user);
	}

	@PostMapping( "/addListUser")
	public List<User> addListUser(@RequestBody List<User> listuser)
	{
		return userServ.addListUser(listuser);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userServ.getListUsers();
	}



	@DeleteMapping("/deleteUser/{id}")
	public void deleteuser(@PathVariable Long id)
	{
		userServ.deleteUser(id);
	}



	@PutMapping( "/updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userServ.updateUser(id, user);
	}



	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userServ.getUserById(id);
	}



	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
		User user = userServ.getUserByUsernameAndPassword(username, password);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}





}
