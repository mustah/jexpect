package com.jexpect.matchers;

import com.jexpect.ToBeString;

public class ExpectToBeString implements ToBeString {

  private final String actual;

  public ExpectToBeString(String actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(String expected) {
    if (anyIsNull(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeNull() {
    if (actual != null) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeEmpty() {
    if (!"".equals(actual)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeNotEmpty() {
    if ("".equals(actual)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean anyIsNull(String expected) {
    return actual == null || expected == null;
  }
}
