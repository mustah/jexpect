package com.jexpect;

import static com.jexpect.Exceptions.throwNewIllegalArgumentException;

class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean actual;

  ExpectToBeBoolean(boolean actual) {
    this.actual = actual;
  }

  @Override
  public void toBeTrue() {
    if (!actual)
      throwNewIllegalArgumentException(true, false);
  }

  @Override
  public void toBeFalse() {
    if (actual)
      throwNewIllegalArgumentException(false, true);
  }

  @Override
  public void toBe(Boolean expected) {
    if (expected == null || actual != expected)
      throwNewIllegalArgumentException(expected, actual);
  }

  @Override
  public ToBeBoolean not() {
    return new ExpectToBeBoolean(!actual);
  }
}
