package com.example.financingapplication.users;

public interface UserDetailService
{
  void registrationUser(String firstName, String lastName, String email, String password,
                        String repeatPassword, String roleName);

  UserDetail getUserByEmail(String email);

  void lockUserAccount(String email, String isAccountLocked);
}
