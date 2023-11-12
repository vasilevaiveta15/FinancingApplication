package com.example.financingapplication.users;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class NamedParameterJdbcUserDao extends UserDetailDaoImpl
{
  public NamedParameterJdbcUserDao(DataSource dataSource)
  {
    super(dataSource);
  }
}
