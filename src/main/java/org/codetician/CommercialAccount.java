package org.codetician;

import java.util.List;

public class CommercialAccount implements AccountInterface {

  private List<Person> authorizedUsers;

  public CommercialAccount(Company company, Long accountNumber, int pin, double balance) {
    // Complete the constructor
  }

  protected void addAuthorizedUser(Person person) {
    // complete the function
  }

  public boolean isAuthorizedUser(Person person) {
    // complete the function
    return true;
  }

}
