package com.curiosity.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
    private String username;
    private String password;
}
