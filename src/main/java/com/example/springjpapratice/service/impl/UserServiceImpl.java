package com.example.springjpapratice.service.impl;

import com.example.springjpapratice.entity.Role;
import com.example.springjpapratice.entity.User;
import com.example.springjpapratice.repository.RoleRepository;
import com.example.springjpapratice.repository.UserRepository;
import com.example.springjpapratice.service.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Override
  public User saveUser(User user) {
    log.info("Saving new user to database");
    return userRepository.save(user);
  }

  @Override
  public Role saveRole(Role role) {
    log.info("Saving new role {} to database", role.getName());
    return roleRepository.save(role);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    log.info("Saving new role {} to user {} to database", roleName, username);
    User user = userRepository.findByUsername(username);
    Role role = roleRepository.findByName(roleName);
    user.getRoles().add(role);
    userRepository.save(user);
  }

  @Override
  public User getUserByName(String username) {
    log.info("Fetching user {}", username);
    return userRepository.findByUsername(username);
  }

  @Override
  public List<User> getUsers() {
    log.info("Fetching all user");
    return userRepository.findAll();
  }
}
