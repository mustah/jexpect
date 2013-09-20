package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;

/**
 * <br> User: must <br> Date: 2013-09-20
 */
class ExpectToBeBoolean implements ToBeBoolean {

  private final boolean expected;

  ExpectToBeBoolean(boolean expected) {
    this.expected = expected;
  }

  @Override
  public void toBeTrue() {
    if (!expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeFalse() {
    if (expected) {
      throw new IllegalArgumentException();
    }
  }
}
