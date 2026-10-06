package org.codetician;

import java.util.ArrayList;
import java.util.List;

public class CommercialAccount extends Account {

  private final List<Person> authorizedUsers;

  public CommercialAccount(Company company,
                           Long accountNumber,
                           int pin,
                           double balance) {
    super(company, accountNumber, pin, balance);
    this.authorizedUsers = new ArrayList<>();
  }

  protected void addAuthorizedUser(Person person) {
    authorizedUsers.add(person);
  }

  public boolean isAuthorizedUser(Person person) {
    return authorizedUsers.contains(person);
  }

}
