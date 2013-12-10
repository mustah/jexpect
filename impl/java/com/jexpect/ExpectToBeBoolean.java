package com.jexpect;

import com.jexpect.api.ToBeBoolean;

class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean actual;

  ExpectToBeBoolean(boolean actual) {
    this.actual = actual;
  }

  @Override
  public void toBeTrue() {
    if (!actual)
      Exceptions.throwNewIllegalArgumentException(true, actual);
  }

  @Override
  public void toBeFalse() {
    if (actual)
      Exceptions.throwNewIllegalArgumentException(false, actual);
  }

  @Override
  public void toBe(Boolean expected) {
    if (expected == null || actual != expected)
      Exceptions.throwNewIllegalArgumentException(expected, actual);
  }

  @Override
  public ToBeBoolean not() {
    return new ExpectToBeBoolean(!actual);
  }
}
