package com.jexpect.matchers;

public class ExpectToBeInteger extends ExpectToBeNumber<Integer> {

  public ExpectToBeInteger(Integer actual) {
    super(actual);
  }

  @Override
  public void toBeLessThan(Integer expected) {
    if (anyIsNull(expected) || actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Integer expected) {
    if (anyIsNull(expected) || actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

}
