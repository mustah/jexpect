package com.jexpect.matchers;

import com.jexpect.ToBeFloat;

class ExpectToBeFloat implements ToBeFloat {

  private final Float actual;

  ExpectToBeFloat(Float actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Float expected) {
    if (cannotBeCompared(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(Float expected) {
    if (cannotBeCompared(expected) || actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Float expected) {
    if (cannotBeCompared(expected) || actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

  private boolean cannotBeCompared(Float expected) {
    return actual == null || expected == null;
  }
}
