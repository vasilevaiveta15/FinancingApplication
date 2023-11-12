package com.example.financingapplication.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserDetailRowMapper implements RowMapper<UserDetail>
{
  @Override
  public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException
  {

    UserDetail userDetail = new UserDetail();
    userDetail.setId(rs.getLong("ID"));
    userDetail.setFirstName(rs.getString("FIRST_NAME"));
    userDetail.setLastName(rs.getString("LAST_NAME"));
    userDetail.setEmail(rs.getString("EMAIL"));
    userDetail.setPassword(rs.getString("PASSWORD"));
    userDetail.setRoleName(UserDetail.RoleName.valueOf(rs.getString("ROLE_NAME")));
    userDetail.setAccountLocked(rs.getString("IS_LOCKED"));
    return userDetail;
  }
}
