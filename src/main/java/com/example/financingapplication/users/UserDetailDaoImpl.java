package com.example.financingapplication.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDetailDaoImpl implements UserDetailDao
{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserDetailDaoImpl(DataSource dataSource)
  {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Transactional
  public void registrationUser(UserDetail user)
  {
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    simpleJdbcInsert.withTableName("USERS").usingGeneratedKeyColumns("ID");

    Map<String, Object> parameters = new HashMap<>(4);
    parameters.put("FIRST_NAME", user.getFirstName());
    parameters.put("LAST_NAME", user.getLastName());
    parameters.put("EMAIL", user.getEmail());
    parameters.put("PASSWORD", user.getPassword());
    parameters.put("ROLE_NAME", user.getRoleName());
    parameters.put("IS_LOCKED", user.isAccountLocked());

    Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
    insertedId.intValue();
  }

  @Override
  @Transactional
  public UserDetail findByEmail(String email)
  {
    return jdbcTemplate.queryForObject("SELECT * FROM USERS U WHERE U.EMAIL = ?",
        new Object[]{email}, new UserDetailRowMapper());
  }

  @Override
  public void lockAccountOfUser(String email, String isAccountLocked)
  {
    jdbcTemplate.update("UPDATE USERS SET IS_LOCKED = ? WHERE EMAIL = ?",isAccountLocked,email);
  }



}
