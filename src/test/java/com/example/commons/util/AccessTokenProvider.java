package com.example.commons.util;

import static io.restassured.RestAssured.given;

import groovy.util.logging.Slf4j;
import io.restassured.http.ContentType;

@Slf4j
public class AccessTokenProvider {

  private static final ConfigurationHolder configurationHolder = ConfigurationHolder.getInstance();
  private static String accessToken;

  public static String getCode() {
    if (accessToken == null) {
      accessToken = given()
          .contentType(ContentType.JSON)
          .body(getBody())
          .post(configurationHolder.getProperty("oauth2.accessTokenURL"))
          .jsonPath()
          .get("data.accessToken");
    }
    return accessToken;
  }

  private static String getBody() {
    String username = configurationHolder.getProperty("oauth2.username");
    String password = configurationHolder.getProperty("oauth2.password");

    String body = """
        {"username": "%s", "password": "%s"}
        """;
    return String.format(body, username, password);
  }
}
