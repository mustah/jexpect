package com.jexpect.matchers;

class ExpectToBeDouble extends ExpectToBeNumber<Double> {

  ExpectToBeDouble(Double actual) {
    super(actual);
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

}
