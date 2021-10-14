package kth.chem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kth.chem.models.User;
import kth.chem.repo.UserRepo;
import kth.chem.response.JsonServerResponse;
import kth.chem.response.ResponseHandler;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserRepo userRepo;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
//		User user = userRepo.save(reqUser);
		System.out.println(user.toString());
//		JsonServerResponse<?> apiResponse = ResponseHandler.createSuccessResponse(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/")
	public ResponseEntity<?> get() {
		List<User> userList = userRepo.findAll();
		JsonServerResponse<User> apiResponse = new JsonServerResponse<>();
		apiResponse.setData(userList);
		apiResponse.setMessage(ResponseHandler.SUCCESS);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
