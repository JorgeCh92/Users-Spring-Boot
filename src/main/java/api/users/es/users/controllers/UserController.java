package api.users.es.users.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.users.es.users.converters.UserConverter;
import api.users.es.users.dtos.UserDTO;
import api.users.es.users.entity.User;
import api.users.es.users.services.UserService;
import api.users.es.users.utils.WrapperResponse;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	private UserConverter userConverter= new UserConverter();
	
	@GetMapping(value="/getusers")
	public ResponseEntity<List<UserDTO>> findAll(
			@RequestParam(value="pageNumber", required = false, defaultValue = "0") int pageNumber, 
			@RequestParam(value="pageSize", required = false, defaultValue = "5") int pageSize)
	{
		Pageable page= PageRequest.of(pageNumber, pageSize);
		
		List<User> users= userService.findAll(page);
		List<UserDTO> usersDTO= userConverter.fromEntity(users);
		
		return new WrapperResponse(true, "success", usersDTO).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value="/getusersById/{userId}")
	public ResponseEntity<WrapperResponse<UserDTO>> findById(@PathVariable("userId") Long userId)
	{
		User user= userService.findById(userId);
		UserDTO userDTO= userConverter.fromEntity(user);
		
		return new WrapperResponse<UserDTO>(true, "success", userDTO).createResponse(HttpStatus.OK);
	}
	
	@PostMapping(value="/createUsers")
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO user)
	{
		User newUser= userService.create(userConverter.fromDTO(user));
		UserDTO userDTO= userConverter.fromEntity(newUser);
		
		return new WrapperResponse(true, "success", userDTO).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateUsersById/{userId}")
	public ResponseEntity<UserDTO> update(@PathVariable("userId") Long userId, @RequestBody UserDTO user)
	{
		User updateUser= userService.update(userId, userConverter.fromDTO(user));
		UserDTO userDTO= userConverter.fromEntity(updateUser);
		
		return new WrapperResponse(true, "success", userDTO).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteUsersById/{userId}")
	public ResponseEntity<?>delete(@PathVariable("userId") Long userId)
	{
		userService.delete(userId);
		
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}
}
