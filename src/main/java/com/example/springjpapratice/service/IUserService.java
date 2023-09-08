package com.example.springjpapratice.service;

import com.example.springjpapratice.entity.Role;
import com.example.springjpapratice.entity.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUserByName(String username);
    List<User> getUsers(); //replace by Page<>
}
