package com.example.company_management_system.controller;

import com.example.company_management_system.model.dto.UserDto;
import com.example.company_management_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public  ResponseEntity creatUser(  @Valid @RequestBody UserDto userDto){

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @GetMapping
    public List<UserDto> findAll(){
        return   userService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> UserGetById(@PathVariable Long id){
        return ResponseEntity.ok(userService.UserGetById(id));

    }
    @PutMapping("/{id}")
    public ResponseEntity updateUserById(@Valid @RequestBody UserDto userDto,@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity deleteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

