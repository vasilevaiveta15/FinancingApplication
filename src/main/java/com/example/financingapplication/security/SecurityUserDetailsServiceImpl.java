package com.example.financingapplication.security;

import com.example.financingapplication.exceptions.InvalidException;
import com.example.financingapplication.users.UserDetail;
import com.example.financingapplication.users.UserDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService
{
  @Autowired
  private UserDetailDao userDetailDao;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
  {
    UserDetail userDetail = this.userDetailDao.findByEmail(email);
    if (userDetail.isAccountLocked().equals("Y")) {
      throw new InvalidException("This account is locked!");
    }

    return org.springframework.security.core.userdetails.User.withUsername(email)
        .password(userDetail.getPassword())
        .roles(userDetail.getRoleName().name())
        .build();
  }
}
