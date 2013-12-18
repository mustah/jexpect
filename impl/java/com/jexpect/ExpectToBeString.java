package com.jexpect;

class ExpectToBeString implements ToBeString {

  private final String actual;

  ExpectToBeString(String actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(String expected) {
    if (actual == null || !actual.equals(expected)) {
      throw new IllegalArgumentException(String.format("Expected to be <%s>, but found: <%s>", expected, actual));
    }
  }

  @Override
  public void toBeNull() {
    if (actual != null) {
      throw new IllegalArgumentException(String.format("Expected to be <%s>, but found: <%s>", "null", actual));
    }
  }

  @Override
  public void toBeEmpty() {
    if (actual == null || !actual.isEmpty()) {
      throw new IllegalArgumentException(String.format("Expected to be <%s>, but found: <%s>", "", actual));
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
        Exceptions.throwNewIllegalArgumentExceptionForNot(null, null);
      }
    }

    @Override
    public void toBeEmpty() {
      if (actual != null && actual.isEmpty()) {
        Exceptions.throwNewIllegalArgumentExceptionForNot("", "");
      }
    }

    @Override
    public void toBe(String expected) {
      if (actual != null && actual.equals(expected)) {
        Exceptions.throwNewIllegalArgumentExceptionForNot(expected, actual);
      }
    }

    @Override
    public ToBeString not() {
      return new ExpectToBeString(actual);
    }
  }
}
