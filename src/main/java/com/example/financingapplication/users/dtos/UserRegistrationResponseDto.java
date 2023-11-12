package com.example.financingapplication.users.dtos;

public class UserRegistrationResponseDto
{
  String firstName;
  String lastName;
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public UserRegistrationResponseDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserRegistrationResponseDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserRegistrationResponseDto setEmail(String email) {
    this.email = email;
    return this;
  }
}
