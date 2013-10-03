package com.jexpect;

import static com.jexpect.util.ExceptionFactory.throwNewIllegalArgumentException;
import static com.jexpect.util.ExceptionFactory.throwNewIllegalArgumentExceptionForNot;

class ExpectToBeString implements ToBeString {

  private final String actual;

  ExpectToBeString(String actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(String expected) {
    if (actual == null || !actual.equals(expected)) {
      throwNewIllegalArgumentException(expected, actual);
    }
  }

  @Override
  public void toBeNull() {
    if (actual != null) {
      throwNewIllegalArgumentException("null", actual);
    }
  }

  @Override
  public void toBeEmpty() {
    if (actual == null || !actual.isEmpty()) {
      throwNewIllegalArgumentException("empty", actual);
    }
  }

  @Override
  public ToBeString not() {
    return new ExpectToBeStringNot(actual);
  }

  private static class ExpectToBeStringNot implements ToBeString {

    private final String actual;

    private ExpectToBeStringNot(String actual) {
      this.actual = actual;
    }

    @Override
    public void toBeNull() {
      if (actual == null) {
        throwNewIllegalArgumentExceptionForNot(null, null);
      }
    }

    @Override
    public void toBeEmpty() {
      if (actual != null && actual.isEmpty()) {
        throwNewIllegalArgumentExceptionForNot("empty", "");
      }
    }

    @Override
    public void toBe(String expected) {
      if (actual != null && actual.equals(expected)) {
        throwNewIllegalArgumentExceptionForNot(expected, actual);
      }
    }

    @Override
    public ToBeString not() {
      return new ExpectToBeString(actual);
    }
  }
}
