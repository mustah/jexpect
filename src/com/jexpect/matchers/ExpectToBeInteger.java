package com.jexpect.matchers;

import com.jexpect.ToBeInteger;

/**
 * <br> User: must <br> Date: 2013-09-20
 */
class ExpectToBeInteger implements ToBeInteger {

  private final int actual;

  ExpectToBeInteger(int actual) {
    this.actual = actual;
  }

  @Override
  public void toBeLessThan(int expected) {
    if (actual >= expected) {
      throw new IllegalArgumentException();
    }
  }
}
