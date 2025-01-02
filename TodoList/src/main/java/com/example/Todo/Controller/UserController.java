package com.example.Todo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Todo.Model.User;
import com.example.Todo.repository.UserRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

	protected static long user_id;
	
	@Autowired
	private UserRepository userRepository;

	//Register
	@PostMapping("/register")
	public boolean saveUserData(@RequestBody User user){
		String username =user.getUsername();
		List<User> users =userRepository.findAll();
		for(User u:users) {
			if(username.equals(u.getUsername()))return true;
		}
		userRepository.save(user);	
		return false;
	 }
	
	//Login
	@PostMapping("/login")
	public boolean findUser(@RequestBody User user){
		String username =user.getUsername();
		String password =user.getPassword();
		List<User> users =userRepository.findAll();
			for(User u:users) {
				if(username.equals(u.getUsername()) && password.equals(u.getPassword()))
					{
					user_id=u.getId();
					return true;
					}
			}
			return false;
	}
	

	
}
