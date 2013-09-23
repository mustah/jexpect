package com.jexpect.matchers;

class ExpectToBeInteger extends ExpectToBeNumber<Integer> {

  ExpectToBeInteger(Integer actual) {
    super(actual);
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

}
