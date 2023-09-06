package com.example.springjpapratice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDTO {
  private Long id;
  private String username;
  private String password;
  private Integer status;
}
