package com.jexpect.matchers;

public class ExpectToBeFloat extends ExpectToBeNumber<Float> {

  public ExpectToBeFloat(Float actual) {
    super(actual);
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

}
