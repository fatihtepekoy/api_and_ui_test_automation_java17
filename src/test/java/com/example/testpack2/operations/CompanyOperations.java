package com.example.testpack2.operations;

import com.example.commons.models.Transaction;
import com.example.commons.util.Utils;
import com.example.testpack2.models.Company;
import io.cucumber.core.options.CurlOption.HttpMethod;
import io.restassured.response.Response;

public class CompanyOperations extends CommonOperationsTwo {

  public CompanyOperations() {
    super();
  }

  public Response createCompany(Transaction transaction) {
    return sendRequest(transaction, HttpMethod.POST, BASE_URL_COMPANY_MAN);
  }

  public Company setUniqueEmail(Company company) {
    company.setCompanyUserEmail(Utils.Unique());
    return company;
  }
}

