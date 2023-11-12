package com.example.financingapplication.users.dtos;

import javax.validation.constraints.Pattern;

public class UserRegistrationRequestDto
{
  private String firstName;
  private String lastName;
  private String email;
  /*At least one upper case, one lower case, one digit, one special character, minimum six */
  @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$\n")
  private String password;
  private String repeatPassword;
  private String roleName;

  public String getFirstName()
  {
    return firstName;
  }

  public UserRegistrationRequestDto setFirstName(String firstName)
  {
    this.firstName = firstName;
    return this;
  }

  public String getLastName()
  {
    return lastName;
  }

  public UserRegistrationRequestDto setLastName(String lastName)
  {
    this.lastName = lastName;
    return this;
  }

  public String getEmail()
  {
    return email;
  }

  public UserRegistrationRequestDto setEmail(String email)
  {
    this.email = email;
    return this;
  }

  public String getPassword()
  {
    return password;
  }

  public UserRegistrationRequestDto setPassword(String password)
  {
    this.password = password;
    return this;
  }

  public String getRepeatPassword()
  {
    return repeatPassword;
  }

  public UserRegistrationRequestDto setRepeatPassword(String repeatPassword)
  {
    this.repeatPassword = repeatPassword;
    return this;
  }

  public String getRoleName()
  {
    return roleName;
  }

  public UserRegistrationRequestDto setRoleName(String roleName)
  {
    this.roleName = roleName;
    return this;
  }
}
