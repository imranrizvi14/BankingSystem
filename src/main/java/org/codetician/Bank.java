package org.codetician;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank implements BankInterface{
  private final ConcurrentHashMap<Long, Account> accounts;
  private final AtomicLong nextAccountNumber;

  public Bank() {
    this.accounts = new ConcurrentHashMap<>();
    this.nextAccountNumber = new AtomicLong(1L);
  }

  @Override
  public Account getAccount(Long accountNumber) {
    return accounts.get(accountNumber);
  }

  @Override
  public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
    if (company == null || startingDeposit < 0) {
      return -1L;
    }
    Long accountNumber = nextAccountNumber.getAndIncrement();
    Account account = new CommercialAccount(
                          company,
                          accountNumber,
                          pin,
                          startingDeposit);
    accounts.put(accountNumber, account);
    return accountNumber;
  }

  @Override
  public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
    if (person == null || startingDeposit < 0) {
      return -1L;
    }
    Long accountNumber = nextAccountNumber.getAndIncrement();
    Account account = new ConsumerAccount(
                          person,
                          accountNumber,
                          pin,
                          startingDeposit);
    accounts.put(accountNumber, account);
    return accountNumber;
  }

  @Override
  public boolean authenticateUser(Long accountNumber, int pin) {
    Account account = accounts.get(accountNumber);
    if (account == null) {
      return false;
    }
    return account.validatePin(pin);
  }

  @Override
  public double getBalance(Long accountNumber) {
    Account account = accounts.get(accountNumber);
    if (account == null) {
      return -1;
    }
    return account.getBalance();
  }

  @Override
  public void credit(Long accountNumber, double amount) {
    Account account = accounts.get(accountNumber);
    if (account == null) {
      return ;
    }
    account.creditAccount(amount);
  }

  @Override
  public boolean debit(Long accountNumber, double amount) {
    Account account = accounts.get(accountNumber);
    if (account == null) {
      return false;
    }
    return account.debitAccount(amount);
  }

}
