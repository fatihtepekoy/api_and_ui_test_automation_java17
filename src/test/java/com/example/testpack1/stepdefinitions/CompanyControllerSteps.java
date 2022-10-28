package com.example.testpack1.stepdefinitions;

import com.example.commons.models.AbstractSteps;
import com.example.testpack1.models.User;
import com.example.testpack1.operations.CompanyUserOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.List;

public class CompanyControllerSteps extends AbstractSteps {

  private final CompanyUserOperations companyUserOperations = new CompanyUserOperations();

  public CompanyControllerSteps() {
  }

  @Given("a valid user with the following details")
  public void aValidUserWith(List<User> users) {
    transaction.getTestContexts().get().setPayload(companyUserOperations.setUniqueEmailAndPhone(users.get(0)));
  }

  @When("I make a POS call to create the user")
  public void iMakeAPOSCall() {
    transaction.setResponse(companyUserOperations.createUser(transaction));
  }

}
