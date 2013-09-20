package com.jexpect.matchers;

import com.jexpect.ToBeInteger;

class ExpectToBeInteger implements ToBeInteger {

  private final int actual;

  ExpectToBeInteger(int actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(int expected) {
    if (actual != expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(int expected) {
    if (actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(int expected) {
    if (actual <= expected) {
      throw new IllegalArgumentException();
    }
  }
}
