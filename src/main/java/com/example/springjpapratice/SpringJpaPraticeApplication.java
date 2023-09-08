package com.example.springjpapratice;

import com.example.springjpapratice.entity.Role;
import com.example.springjpapratice.entity.User;
import com.example.springjpapratice.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJpaPraticeApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringJpaPraticeApplication.class, args);
    System.out.println("custom.messages");
  }

  @Bean
  CommandLineRunner run(IUserService userService) {
    return args -> {
//      userService.saveRole(new Role(null, "ROLE_USER"));
//      userService.saveRole(new Role(null, "ROLE_MANAGER"));
//      userService.saveRole(new Role(null, "ROLE_ADMIN"));
//      userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//      userService.saveUser(new User(null, "Le Duc Anh", "anhld1", "1234"));
//      userService.saveUser(new User(null, "Nguyen Van Dung", "dung.nv", "1234"));
//      userService.saveUser(new User(null, "Ly Binh", "binh.l", "1234"));
//      userService.saveUser(new User(null, "Mac Dinh Chi", "chi.md", "1234"));

      userService.addRoleToUser("andld1", "ROLE_SUPER_ADMIN");
      userService.addRoleToUser("andld1", "ROLE_ADMIN");
      userService.addRoleToUser("andld1", "ROLE_USER");
      userService.addRoleToUser("dung.nv", "ROLE_MANAGER");
      userService.addRoleToUser("binh.l", "ROLE_ADMIN");
      userService.addRoleToUser("chi.md", "ROLE_USER");
    };
  }
}
