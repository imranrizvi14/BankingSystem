package org.codetician;

public abstract class Account {
  private AccountHolder accountHolder;
  private Long accountNumber;
  private int pin;
  private double balance;

  protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double balance) {
    // complete the constructor
  }

  public AccountHolder getAccountHolder() {
    // complete the function
    return null;
  }

  public boolean validatePin(int attemptedPin) {
    // complete the function
    return true;
  }

  public double getBalance() {
    // complete the function
    return -1;
  }

  public Long getAccountNumber() {
    // complete the function
    return -1L;
  }

  public void creditAccount(double amount) {
    // complete the function
  }

  public boolean debitAccount(double amount) {
    // complete the function
    return true;
  }

}
