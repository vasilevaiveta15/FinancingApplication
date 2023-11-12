package com.example.financingapplication.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ContractDaoImpl implements ContractDao
{
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ContractDaoImpl(DataSource dataSource){
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
  @Transactional
  public void createContract(Contract contract){
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    simpleJdbcInsert.withTableName("CONTRACTS").usingGeneratedKeyColumns("ID");

    Map<String, Object> parameters = new HashMap<>(2);
    parameters.put("FILE_DIRECTORY", contract.getFileLocation());
    parameters.put("FILE_NAME", contract.getFileName());

    Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
    insertedId.intValue();
  }

}
