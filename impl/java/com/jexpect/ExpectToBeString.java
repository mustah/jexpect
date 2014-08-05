package com.jexpect;

import static com.jexpect.Exceptions.throwNewIllegalArgumentException;
import static com.jexpect.Exceptions.throwNewIllegalArgumentExceptionForNot;

class ExpectToBeString implements ToBeString {

  private final StringMatcher matcher;

  ExpectToBeString(StringMatcher matcher) {
    this.matcher = matcher;
  }

  @Override
  public void toBe(String expected) {
    if (matcher.isNotEqualTo(expected)) {
      throwNewIllegalArgumentException(expected, matcher.getActual());
    }
  }

  @Override
  public void toBeNull() {
    if (matcher.isNotNull()) {
      throwNewIllegalArgumentException("null", matcher.getActual());
    }
  }

  @Override
  public void toBeEmpty() {
    if (matcher.isNotEmpty()) {
      throwNewIllegalArgumentException("", matcher.getActual());
    }
  }

  @Override
  public ToBeString not() {
    return new ExpectToBeStringNot(matcher);
  }

  private static class ExpectToBeStringNot implements ToBeString {

    private final StringMatcher matcher;

    private ExpectToBeStringNot(StringMatcher matcher) {
      this.matcher = matcher;
    }

    @Override
    public void toBeNull() {
      if (matcher.isNull()) {
        throwNewIllegalArgumentExceptionForNot(null, null);
      }
    }

    @Override
    public void toBeEmpty() {
      if (matcher.isEmpty()) {
        throwNewIllegalArgumentExceptionForNot("", "");
      }
    }

    @Override
    public void toBe(String expected) {
      if (matcher.isEqualTo(expected)) {
        throwNewIllegalArgumentExceptionForNot(expected, matcher.getActual());
      }
    }

    @Override
    public ToBeString not() {
      return new ExpectToBeString(matcher);
    }
  }
}
