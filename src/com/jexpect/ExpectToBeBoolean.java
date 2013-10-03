package com.jexpect;

import static com.jexpect.util.ExceptionFactory.throwNewIllegalArgumentException;

class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean actual;

  ExpectToBeBoolean(boolean actual) {
    this.actual = actual;
  }

  @Override
  public void toBeTrue() {
    if (!actual) {
      throwNewIllegalArgumentException("true", Boolean.toString(actual));
    }
  }

  @Override
  public void toBeFalse() {
    if (actual) {
      throwNewIllegalArgumentException("false", Boolean.toString(actual));
    }
  }

  @Override
  public void toBe(Boolean expected) {
    if (actual != expected) {
      throwNewIllegalArgumentException(Boolean.toString(expected), Boolean.toString(actual));
    }
  }

  @Override
  public ToBeBoolean not() {
    return new ExpectToBeBoolean(!actual);
  }
}
