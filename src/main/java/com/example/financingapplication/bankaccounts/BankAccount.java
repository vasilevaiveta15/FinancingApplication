package com.example.financingapplication.bankaccounts;

public class BankAccount
{
  private Long id;
  private String username;
  private Long bankAccountNumber;
  private Double moneyAccount;

  public BankAccount()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public Long getBankAccountNumber()
  {
    return bankAccountNumber;
  }

  public void setBankAccountNumber(Long bankAccountNumber)
  {
    this.bankAccountNumber = bankAccountNumber;
  }

  public Double getMoneyAccount()
  {
    return moneyAccount;
  }

  public void setMoneyAccount(Double moneyAccount)
  {
    this.moneyAccount = moneyAccount;
  }
}
