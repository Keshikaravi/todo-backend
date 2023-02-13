package com.javaguides.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaguides.sample.exception.ResourceNotFoundException;
import com.javaguides.sample.model.User;
import com.javaguides.sample.repository.UserRepository;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId )
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

    @PostMapping("users")
	public User createUser(@Validated @RequestBody User user) {
		return userRepository.save(user);
	}
    

    @PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
        user.setProfile_id(userDetails.getProfile_id());
		user.setUsername(userDetails.getUsername());
		user.setUserpwd(userDetails.getUserpwd());
		
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
            }
        @DeleteMapping("/users/{id}")
        public Map<String,Boolean> deleteUser(@PathVariable(value = "id") Long userId)
      
                throws ResourceNotFoundException {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
    
            userRepository.delete(user);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }

}
