package com.example;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/reports/cucumber-test-report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.shipmercury.apiautomation.titan")
class RunCucumberTest {

  @BeforeAll
  void setup() {
    //TODO verify this and logs
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    String substring = "abc".substring(2);
  }

  @AfterAll
  void cleanUp() {
    
  }
}
