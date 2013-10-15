package com.jexpect;

import static com.jexpect.Exceptions.throwNewIllegalArgumentException;

class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean actual;

  ExpectToBeBoolean(boolean actual) {
    this.actual = actual;
  }

  @Override
  public void toBeTrue() {
    if (!actual) {
      throwNewIllegalArgumentException(true, actual);
    }
  }

  @Override
  public void toBeFalse() {
    if (actual) {
      throwNewIllegalArgumentException(false, actual);
    }
  }

  @Override
  public void toBe(Boolean expected) {
    if (actual != expected) {
      throwNewIllegalArgumentException(expected, actual);
    }
  }

  @Override
  public ToBeBoolean not() {
    return new ExpectToBeBoolean(!actual);
  }
}
