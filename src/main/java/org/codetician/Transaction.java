package org.codetician;

public class Transaction {
  private Long accountNumber;
  private Bank bank;

  public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
    // Complete this constructor
  }

  public double getBalance() {
    // complete this function
    return -1;
  }

  public void credit(double amount) {
    // complete this function
  }

  public boolean debit (double amount) {
    // complete this function
    return true;
  }

}
