package com.example.testpack2.stepdefinitions;

import com.example.commons.models.AbstractSteps;
import com.example.testpack2.models.Company;
import com.example.testpack2.operations.CompanyOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.List;

public class CompanyControllerSteps extends AbstractSteps {

  private final CompanyOperations companyOperations = new CompanyOperations();

  @Given("a valid company with the following details")
  public void aValidCompanyWithTheFollowingDetails(List<Company> companies) {
    transaction.setPayload(companyOperations.setUniqueEmail(companies.get(0)));
  }

  @When("I make a POS call to create the company")
  public void iMakeAPOSCallToCreateTheCompany() {
    transaction.setResponse(companyOperations.createCompany(transaction));
  }

}

