package com.example.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserContoller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/allusers")
    public ResponseEntity<?> getAllUsers(){
        Response response = new Response();
        List<User> userList = userRepository.findAll();
        response.setStatus("Success");
        response.setUserList(userList);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping("/insertuser")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        Response response = new Response();
        User savedUser = userRepository.save(user);
        response.setStatus("Success");
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }

}
