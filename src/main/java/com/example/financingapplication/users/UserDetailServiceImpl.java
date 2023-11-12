package com.example.financingapplication.users;

import com.example.financingapplication.exceptions.InvalidException;
import com.example.financingapplication.exceptions.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService
{
  private final UserDetailDao   userDetailDao;
  private final PasswordEncoder passwordEncoder;


  @Autowired
  public UserDetailServiceImpl(UserDetailDao userDetailDao)
  {
    this.userDetailDao = userDetailDao;
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  @Override
  public void registrationUser(String firstName, String lastName, String email, String password,
                               String repeatPassword, String roleName)
  {
    UserDetail userDetail = new UserDetail();
    userDetail.setFirstName(firstName);
    userDetail.setLastName(lastName);
    userDetail.setEmail(email);
    userDetail.setPassword(this.passwordEncoder.encode(password));
    userDetail.setAccountLocked("N");
    if (!password.equals(repeatPassword)) {
      throw new PasswordException("Password don't match!");
    }

    if (!(roleName.equals("SUPPLIER") || roleName.equals("FACTOR"))) {
      throw new InvalidException("Invalid role!");
    }
    userDetail.setRoleName(UserDetail.RoleName.valueOf(roleName));
    this.userDetailDao.registrationUser(userDetail);
  }

  @Override
  public UserDetail getUserByEmail(String email)
  {
    return this.userDetailDao.findByEmail(email);
  }

  @Override
  public void lockUserAccount(String email, String isAccountLocked)
  {
    if (!(isAccountLocked.equals("Y") || isAccountLocked.equals("N"))) {
      throw new InvalidException("You must choose Y to lock account or N to unlock!");
    }
    this.userDetailDao.lockAccountOfUser(email, isAccountLocked);
  }


}
