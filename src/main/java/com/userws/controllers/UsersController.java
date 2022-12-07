package com.userws.controllers;

import com.userws.commands.CreateUserCommand;
import com.userws.dtos.UserDto;
import com.userws.entities.User;
import com.userws.mappers.UserMapper;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = {"/users"}
)
public class UsersController {

    private CommandGateway commandGateway;

    public UsersController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping("/{id}")
    public String getUserById(String id) {
        return "User with id " + id;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);
        CreateUserCommand command = CreateUserCommand.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        String returnValue = "";
        try {
            returnValue = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnValue);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public String getAllUsers() {
        return "All users";
    }


}
