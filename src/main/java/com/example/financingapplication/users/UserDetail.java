package com.example.financingapplication.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.data.annotation.Transient;

public class UserDetail implements GrantedAuthority
{

  @Override
  @Transient
  public String getAuthority()
  {
    return "ROLE_" + roleName.toString();
  }

  public enum RoleName
  {
    SUPPLIER,
    FACTOR,
    ADMIN
  }

  private Long     id;
  private String   firstName;
  private String   lastName;
  private String   email;
  private String   password;
  private RoleName roleName;
  private String  isAccountLocked;

  public UserDetail()
  {

  }

  public UserDetail(String firstName, String lastName, String email, String password,
                    RoleName roleName, String isAccountLocked)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roleName = roleName;
    this.isAccountLocked = isAccountLocked;
  }


  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public RoleName getRoleName()
  {
    return roleName;
  }

  public void setRoleName(RoleName roleName)
  {
    this.roleName = roleName;
  }

  public String isAccountLocked()
  {
    return isAccountLocked;
  }

  public void setAccountLocked(String accountLocked)
  {
    isAccountLocked = accountLocked;
  }
}
