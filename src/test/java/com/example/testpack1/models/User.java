package com.example.testpack1.models;

import lombok.Data;

@Data
public class User {

  private String type;
  private String title;
  private String firstName;
  private String lastName;
  private String email;
  private Phone phone = new Phone();
//  private Phone mobilePhone = new Phone();
}
