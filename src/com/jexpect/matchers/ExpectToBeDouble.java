package com.jexpect.matchers;

import com.jexpect.ToBeNumber;

class ExpectToBeDouble implements ToBeNumber<Double> {

  private final Double actual;

  ExpectToBeDouble(Double actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Double expected) {
    if (cannotBeCompared(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(Double expected) {
    if (cannotBeCompared(expected) || actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Double expected) {
    if (cannotBeCompared(expected) || actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

  private boolean cannotBeCompared(Double expected) {
    return actual == null || expected == null;
  }

}
