package com.example.testpack1.operations;

import com.example.commons.operations.BaseEndpointModel;

public abstract class CommonOperationsOne extends BaseEndpointModel {

  protected static final String BASE_URL_BFF = CONFIG.getProperty("baseUrl.bff");

  public String getBaseUrl() {
    return BASE_URL_BFF;
  }

}
