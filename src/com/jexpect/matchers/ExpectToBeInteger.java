package com.jexpect.matchers;

import com.jexpect.ToBeInteger;

class ExpectToBeInteger implements ToBeInteger {

  private final Integer actual;

  ExpectToBeInteger(Integer actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Integer expected) {
    if (cannotBeCompared(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(Integer expected) {
    if (cannotBeCompared(expected) || actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Integer expected) {
    if (cannotBeCompared(expected) || actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

  private boolean cannotBeCompared(Integer expected) {
    return actual == null || expected == null;
  }
}
