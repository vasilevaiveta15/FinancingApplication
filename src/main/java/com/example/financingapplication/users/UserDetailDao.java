package com.example.financingapplication.users;

public interface UserDetailDao
{
  void registrationUser(UserDetail userDetail);

  UserDetail findByEmail(String email);

  void lockAccountOfUser(String email, String isAccountLocked);


}
