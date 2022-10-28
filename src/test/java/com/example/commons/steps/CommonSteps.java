package com.example.commons.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.commons.models.AbstractSteps;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

@Slf4j
public class CommonSteps extends AbstractSteps {

  @Then("the response is successful")
  public void isResponseSuccessful() {
    log.info(transaction.getPayloadWithJson());
    assertEquals(HttpStatus.SC_OK, transaction.getResponse().getStatusCode());
    //TODO -> assertJ
  }


}
