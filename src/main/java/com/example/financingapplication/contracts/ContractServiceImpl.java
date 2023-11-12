package com.example.financingapplication.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractServiceImpl implements ContractService
{
  private final ContractDao contractDao;

  @Autowired
  public ContractServiceImpl(ContractDao contractDao)
  {
    this.contractDao = contractDao;
  }
}
