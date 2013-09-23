package com.jexpect.matchers;

import com.jexpect.ToBeDouble;

class ExpectToBeDouble implements ToBeDouble {

  private final double actual;

  ExpectToBeDouble(double actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Double expected) {
    if (expected == null || actual != expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(double expected) {
    if (actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(double expected) {
    if (actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

}
