package com.ems.user.impl;

import com.ems.entities.JpaUser;
import com.ems.user.api.IUser;
import com.ems.user.model.User;
import com.ems.user.model.UserMapper;
import com.google.inject.Inject;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

public class DefaultUserImpl implements IUser {
    private JPAApi jpaApi;

    @Inject
    public DefaultUserImpl(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Override
    @Transactional
    public String
    addEmployee(User user){
        String email = user.getEmail();

        // Check if a user with the same email already exists
        TypedQuery<JpaUser> query = jpaApi.em().createQuery("SELECT u FROM JpaUser u WHERE u.email = :email", JpaUser.class);
        query.setParameter("email", email);
        List<JpaUser> existingUsers = query.getResultList();

        if (!existingUsers.isEmpty()) {
            // User with the same email already exists
            return null;
        }

        JpaUser jpaUser = UserMapper.userToJpaUser(user);
        jpaUser.setUuid(UUID.randomUUID().toString());
        jpaUser.setType("user");
        jpaUser.setUpdatedAt(LocalDateTime.now());
        jpaUser.setCreatedAt(LocalDateTime.now());
        System.out.println(jpaUser);

        jpaApi.em().persist(jpaUser);

        return jpaUser.getUuid();
    };

    @Override
    public String loginUser(User user){
        // Check if a user with the same email already exists
        TypedQuery<JpaUser> query = jpaApi.em().createQuery("SELECT u FROM JpaUser u WHERE u.email = :email", JpaUser.class);
        query.setParameter("email", user.getEmail());
        List<JpaUser> existingUsers = query.getResultList();

        if (!existingUsers.isEmpty()) {
            // User with the same email already exists
            return null;
        }

        if(existingUsers.get(0).getPassword() != user.getPassword() ){
            throw new RuntimeException("Invalid password");
        }

        return existingUsers.get(0).getUuid();
    };

    @Override
    public Optional<User> getEmployee(Long userId){
        final var user = jpaApi.withTransaction(entityManager -> entityManager.find(JpaUser.class, userId));
        return Optional.ofNullable(user).map(UserMapper::jpaUserToUser);
    };

    @Override
    public List<User> getEmployees(){
        TypedQuery<JpaUser> query = jpaApi.em().createQuery("SELECT u FROM JpaUser u", JpaUser.class);
        List<JpaUser> existingUsers = query.getResultList();

        List<User> userList = new ArrayList<>();
        for(JpaUser user: existingUsers){
            userList.add(UserMapper.jpaUserToUser(user));
        }
        return userList;
    }

    @Override
    public String removeEmployee(Long userId){
        TypedQuery<JpaUser> query = jpaApi.em().createQuery("DELETE FROM JpaUser WHERE id = :userId", JpaUser.class);
        query.setParameter("userId", userId);
        query.executeUpdate();

        return "Employee removed";
    }
}
