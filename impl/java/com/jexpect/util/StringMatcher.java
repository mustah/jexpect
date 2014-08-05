package com.jexpect.util;

public class StringMatcher {

  private final String str;

  public StringMatcher(String str) {
    this.str = str;
  }

  public boolean isEqualTo(String expected) {
    return str != null && str.equals(expected);
  }

  public boolean isNotEqualTo(String expected) {
    return !isEqualTo(expected);
  }

  public boolean isNotNull() {
    return str != null;
  }

  public boolean isNull() {
    return str == null;
  }

  public boolean isEmpty() {
    return str != null && str.isEmpty();
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public String getActual() {
    return str;
  }
}
