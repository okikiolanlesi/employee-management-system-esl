package com.ems.user.model;

import com.ems.entities.JpaUser;

public class UserMapper {

    public static JpaUser userToJpaUser(User user){
        JpaUser jpaUser = new JpaUser();
        jpaUser.setUuid(user.getUuid());
        jpaUser.setCreatedAt(user.getCreatedAt());
        jpaUser.setType(user.getType());
        jpaUser.setEmail(user.getEmail());
        jpaUser.setId(user.getId());
        jpaUser.setName(user.getName());
        jpaUser.setPassword(user.getPassword());
        jpaUser.setUpdatedAt(user.getUpdatedAt());
        return jpaUser;
    }

    public static User jpaUserToUser(JpaUser jpaUser){
        User user = new User();
        user.setUuid(jpaUser.getUuid());
        user.setCreatedAt(jpaUser.getCreatedAt());
        user.setType(jpaUser.getType());
        user.setEmail(jpaUser.getEmail());
        user.setId(jpaUser.getId());
        user.setName(jpaUser.getName());
        user.setPassword(jpaUser.getPassword());
        user.setUpdatedAt(jpaUser.getUpdatedAt());
        return user;
    }
}
