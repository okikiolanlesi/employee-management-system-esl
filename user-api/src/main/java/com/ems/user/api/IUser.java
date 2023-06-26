package com.ems.user.api;

import com.ems.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUser {
    String addEmployee(User user);
    String loginUser(User user);
    String removeEmployee(Long userId);
    List<User> getEmployees();
    Optional<User> getEmployee(Long userId);
}
