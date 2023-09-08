package com.example.springjpapratice.api;

import com.example.springjpapratice.entity.Role;
import com.example.springjpapratice.entity.User;
import com.example.springjpapratice.service.IUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
  private final IUserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUser() {
    return ResponseEntity.ok(userService.getUsers());
  }

  @PostMapping("/user/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri =
        URI.create(
            ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/save")
                .toUriString());
    return ResponseEntity.created(uri).body(userService.saveUser(user));
  }

  @PostMapping("/role/save")
  public ResponseEntity<Role> saveRole(@RequestBody Role role) {
    URI uri =
        URI.create(
            ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/role/save")
                .toUriString());
    return ResponseEntity.created(uri).body(userService.saveRole(role));
  }

  @PostMapping("/user/save-role")
  public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
    userService.addRoleToUser(form.getUsername(), form.getRoleName());
    return ResponseEntity.ok(null);
  }

  @GetMapping("/user/get-by-user-name")
  public ResponseEntity<User> getUserByUserName(@RequestParam String username) {
    return ResponseEntity.ok(userService.getUserByName(username));
  }
}

@Data
class RoleToUserForm {
  private String username;
  private String roleName;
}
