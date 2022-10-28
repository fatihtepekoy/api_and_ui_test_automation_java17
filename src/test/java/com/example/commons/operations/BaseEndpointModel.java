package com.example.commons.operations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.commons.models.Transaction;
import com.example.commons.util.ConfigurationHolder;
import io.cucumber.core.options.CurlOption.HttpMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

public abstract class BaseEndpointModel {

  protected static final ConfigurationHolder CONFIG = ConfigurationHolder.getInstance();

  public BaseEndpointModel() {
  }

  public void verifyResponseKeyValues(String key, String val, Response r) {
    String value = r.jsonPath().getString(key);
    assertThat(value, is(val));
  }

  public void verifyTrue(boolean val) {
    Assertions.assertTrue(val);
  }

  public void verifyFalse(boolean val) {
    Assertions.assertFalse(val);
  }

  public void verifyResponseStatusValue(Response response, int expectedCode) {
    assertThat(response.getStatusCode(), is(expectedCode));
  }

  public void verifyNestedResponseKeyValues(String nestTedCompnent, String key, String val,
      Response r) {
    Map<String, String> nestedJSON = r.jsonPath().getMap(nestTedCompnent);
    String actual = String.valueOf(nestedJSON.get(key));
    assertThat(actual, is(val));
  }

  public void verifyNestedArrayValueResponseKeyValues(String nestTedCompnent, String[] val,
      Response r) {

    ArrayList<Object> nestedArray = (ArrayList<Object>) r.jsonPath().getList(nestTedCompnent);

    String actual;

    for (int i = 0; i < nestedArray.size(); i++) {
      actual = (String) nestedArray.get(i);
      assertThat(actual, is(val[i]));
    }
  }

  public void verifyNestedArrayMapResponseKeyValues(String nestTedCompnent, String key,
      String[] val, Response r) {
    ArrayList<Object> nestedArray = (ArrayList<Object>) r.jsonPath().getList(nestTedCompnent);

    String actual;
    for (int i = 0; i < nestedArray.size(); i++) {
      Map<String, String> map = (Map<String, String>) nestedArray.get(i);
      actual = String.valueOf(map.get(key));
      assertThat(actual, is(val[i]));
    }
  }

  protected JSONObject createJSONPayload(Object pojo) {
    return new JSONObject(pojo);
  }

  protected Response sendRequest(Transaction transaction,HttpMethod httpMethod, String url) {
    Response response = null;

    RequestSpecification request = transaction.getRequest();
    String accessToken = Transaction.getAccessToken();
    Object pojo = transaction.getPayload();

    if (null != pojo) {
      String payload = createJSONPayload(pojo).toString();
      request.body(payload);
    }

    // need to add a switch based on request type
    switch (httpMethod) {
      case GET:
        if (request == null) {
          response = RestAssured.given().auth().oauth2(accessToken).when().get(url);
        } else {
          response = request.auth().oauth2(accessToken).get(url);
        }
        break;
      case POST:
        if (request == null) {
          response = RestAssured.given().auth().oauth2(accessToken).when().post(url);
        } else {
          response = request.auth().oauth2(accessToken).post(url);
        }
        break;
      case DELETE:
        if (request == null) {
          response = RestAssured.given().auth().oauth2(accessToken).when().delete(url);
        } else {
          response = request.auth().oauth2(accessToken).delete(url);
        }
        break;
      case PUT:
        if (request == null) {
          response = RestAssured.given().auth().oauth2(accessToken).when().put(url);
        } else {
          response = request.auth().oauth2(accessToken).put(url);
        }
        break;
      case PATCH:
        if (request == null) {
          response = RestAssured.given().auth().oauth2(accessToken).when().patch(url);
        } else {
          response = request.auth().oauth2(accessToken).patch(url);
        }
        break;
      default:
        break;
    }
    return response;
  }

  public static Response getResponse(String path) {
    return given().get(path);
  }

  public static Response getResponse() {
    return given().get();
  }

  public static JsonPath getJsonPath(Response res) {
    String json = res.asString();
    return new JsonPath(json);
  }

}
