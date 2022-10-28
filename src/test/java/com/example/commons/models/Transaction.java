package com.example.commons.models;

import static java.lang.ThreadLocal.withInitial;

import com.example.commons.util.AccessTokenProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Transaction {

  private static final String ACCESS_TOKEN = AccessTokenProvider.getCode();

  private final ThreadLocal<TestContext> testContexts = withInitial(TestContext::new);

  public Transaction() {
    setRequest(RestAssured.given().header("Content-Type", "application/json"));
  }

  public void setRequestWithXmlHeaders() {
    setRequest(RestAssured.given().header("Content-Type", "application/xml"));
  }

  public RequestSpecification getRequest() {
   return testContexts.get().getRequest();
  }

  private void setRequest(RequestSpecification requestSpecification) {
    testContexts.get().setRequest(requestSpecification);
  }

  public Response getResponse() {
    return testContexts.get().getResponse();
  }

  public void setResponse(Response response) {
    testContexts.get().setResponse(response);
  }

  public Object getPayload() {
    return testContexts.get().getPayload();
  }

  public String getPayloadWithJson() {
    return testContexts.get().getPayloadWithJson();
  }

  public static String getAccessToken() {
    return ACCESS_TOKEN;
  }

  public void setPayload(Object payload){
    testContexts.get().setPayload(payload);
  }

  public ThreadLocal<TestContext> getTestContexts() {
    return testContexts;
  }
}
