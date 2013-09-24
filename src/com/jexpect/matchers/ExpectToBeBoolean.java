package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;

public class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean actual;

  public ExpectToBeBoolean(boolean actual) {
    this.actual = actual;
  }

  @Override
  public void toBeTrue() {
    if (!actual) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeFalse() {
    if (actual) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBe(Boolean expected) {
    if (actual != expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public ToBeBoolean not() {
    return new ExpectToBeBoolean(!actual);
  }
}
