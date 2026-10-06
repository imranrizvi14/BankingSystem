package org.codetician;

public abstract class Account {
  private AccountHolder accountHolder;
  private Long accountNumber;
  private int pin;
  private double balance;

  protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double balance) {
    this.accountHolder = accountHolder;
    this.accountNumber = accountNumber;
    this.pin = pin;
    this.balance = balance;
  }

  public AccountHolder getAccountHolder() {
    return accountHolder;
  }

  public boolean validatePin(int attemptedPin) {
    return this.pin == attemptedPin;
  }

  public double getBalance() {
    synchronized (this) {
      return balance;
    }
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public synchronized void creditAccount(double amount) {
    balance += amount;
  }

  public synchronized boolean debitAccount(double amount) {
    if (balance < amount) {
      return false;
    }
    balance -= amount;
    return true;
  }

}
