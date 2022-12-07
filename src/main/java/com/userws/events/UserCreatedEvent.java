package com.userws.events;


import lombok.Data;

@Data
public class UserCreatedEvent {

    private Long id;
    private String name;
    private String email;
    private String password;
}
