package com.example.springjpapratice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  private final Collection<Role> roles = new ArrayList<>();
}
