package com.example.commons.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public class TestContext {

  private RequestSpecification request;
  private Response response;
  private Object payload;

  public Object getPayload() {
    return payload;
  }

  public <T> T getPayload(Class<T> clazz) {
    return clazz.cast(payload);
  }

  public <T> void setPayload(T object) {
    payload = object;
  }

  public String getPayloadWithJson() {
    String json;
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    try {
      json = ow.writeValueAsString(payload);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return json;
  }

}
