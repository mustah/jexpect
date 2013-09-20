package com.jexpect.matchers;

import com.jexpect.ToBeFloat;

class ExpectToBeFloat implements ToBeFloat {

  private final float actual;

  ExpectToBeFloat(float actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(float expected) {
    if (actual != expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(float expected) {
    if (actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(float expected) {
    if (actual <= expected) {
      throw new IllegalArgumentException();
    }
  }
}
