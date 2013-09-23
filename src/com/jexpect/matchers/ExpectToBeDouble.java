package com.jexpect.matchers;

import com.jexpect.ToBeDouble;

class ExpectToBeDouble implements ToBeDouble {

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
    return expected == null || actual == null;
  }

}
