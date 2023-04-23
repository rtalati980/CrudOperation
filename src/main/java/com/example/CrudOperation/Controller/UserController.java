package com.example.CrudOperation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOperation.To.User;
import com.example.CrudOperation.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userSer;
	
	@GetMapping("/")
	public  List<User> getAllUser() {
		return userSer.getAllUsers();	
	}
	@GetMapping("/{id}")
	public Optional<User> findByid(@PathVariable int id){
	return userSer.findById(id);
}
  @PostMapping("/add")
  public User add(@RequestBody User user) {
	return userSer.saveData(user); 
  }
	@PutMapping("/{id}")
	public void update(@PathVariable int id){ 
				userSer.updateById(id);
			
}   
     @DeleteMapping("/{id}")   
     public void delete(@PathVariable int id)
     {
    	 userSer.delete(id);
}
}