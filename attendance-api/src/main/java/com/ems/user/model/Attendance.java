package com.ems.user.model;

import com.ems.entities.JpaUser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Attendance implements Serializable {

    private Long id;

    private JpaUser user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Attendance(){

    }

    public Attendance(JpaUser user){
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUser(JpaUser user){
        this.user = user;
    }

    public JpaUser getUser() {
        return user;
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
                "user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                " }";
    }
}

