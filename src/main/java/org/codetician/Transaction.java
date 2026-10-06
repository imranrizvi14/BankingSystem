package org.codetician;

public class Transaction implements TransactionInterface{
  private Long accountNumber;
  private Bank bank;

  /**
   * @param bank The bank where the account is housed.
   * @param accountNumber The customer's account number.
   * @param attemptedPin The PIN entered by the customer.
   * @throws Exception Account validation failed. // this comments was provided that is why throwing exception
   */
  public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
    if (!bank.authenticateUser(accountNumber, attemptedPin)) {
      throw new Exception("Account validation failed");
    }
    this.bank = bank;
    this.accountNumber = accountNumber;
  }

  @Override
  public double getBalance() {
    return bank.getBalance(accountNumber);
  }

  @Override
  public void credit(double amount) {
    bank.credit(accountNumber, amount);
  }

  @Override
  public boolean debit (double amount) {
    return bank.debit(accountNumber, amount);
  }

}
