package com.example.testpack1.operations;

import com.example.commons.models.Transaction;
import com.example.commons.util.Constants;
import com.example.commons.util.Utils;
import com.example.testpack1.models.User;
import io.cucumber.core.options.CurlOption.HttpMethod;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyUserOperations extends CommonOperationsOne {

  private static final String USER_PATH = "/users?companyId=" + Constants.QAA_COMPANY_ID;

  public CompanyUserOperations() {
    super();
  }

  private String getUserPath() {
    return getBaseUrl() + USER_PATH;
  }

  public Response createUser(Transaction transaction) {
    return sendRequest(transaction, HttpMethod.POST, getUserPath());
  }

  public User setUniqueEmailAndPhone(User user) {
    user.setEmail(Utils.Unique());
    user.getPhone().setPhoneCountryCode("1");
    user.getPhone().setPhoneNumber(Utils.generateRandomPhoneNumber(10));
    user.getPhone().setPhoneNumberExtension(Utils.generateRandomPhoneNumber(4));
    return user;
  }
}
