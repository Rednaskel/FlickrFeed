package com.malak.yaim.model;

import java.util.HashMap;
import java.util.Map;

public class Media {

  private String m;
  /*TODO Suppose I dont need any of additionalProperties */
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getM() {
    return m;
  }

  public void setM(String m) {
    this.m = m;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
