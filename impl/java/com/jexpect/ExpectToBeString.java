package com.jexpect;

import com.jexpect.api.ToBeString;

class ExpectToBeString implements ToBeString {

  private static final String STRING_NAMED_EMPTY = "empty";

  private final String actual;

  ExpectToBeString(String actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(String expected) {
    if (actual == null || !actual.equals(expected))
      Exceptions.throwNewIllegalArgumentException(expected, actual);
  }

  @Override
  public void toBeNull() {
    if (actual != null)
      Exceptions.throwNewIllegalArgumentException("null", actual);
  }

  @Override
  public void toBeEmpty() {
    if (actual == null || !actual.isEmpty())
      Exceptions.throwNewIllegalArgumentException(STRING_NAMED_EMPTY, actual);
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
      if (actual == null)
        Exceptions.throwNewIllegalArgumentExceptionForNot(null, null);
    }

    @Override
    public void toBeEmpty() {
      if (actual != null && actual.isEmpty())
        Exceptions.throwNewIllegalArgumentExceptionForNot(STRING_NAMED_EMPTY, "");
    }

    @Override
    public void toBe(String expected) {
      if (actual != null && actual.equals(expected))
        Exceptions.throwNewIllegalArgumentExceptionForNot(expected, actual);
    }

    @Override
    public ToBeString not() {
      return new ExpectToBeString(actual);
    }
  }
}
