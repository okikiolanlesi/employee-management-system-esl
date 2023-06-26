package com.ems.user.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String uuid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(){

    }
    public User(String email, String password, String type, String name){
        this.email = email;
        this.password = password;
        this.type = type;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setCreatedAt(LocalDateTime dateTime) {
        this.createdAt = dateTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(LocalDateTime dateTime) {
        this.updatedAt = dateTime;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "{ " +
                "name=" + name +
                ", type=" + type +
                ", email=" + email +
                ", password=" + password +
                ", uuid=" + uuid +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                " }";
    }
}