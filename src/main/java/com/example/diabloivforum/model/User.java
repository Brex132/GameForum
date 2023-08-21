package com.example.diabloivforum.model;

import jakarta.persistence.*;

@Entity
public class User {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            Long Id;
            @Column(nullable = false)
    String username;
            @Column
    String password;

    public User() {

    }
    public User(Long id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
