package com.jexpect.matchers;

class ExpectToBeLong extends ExpectToBeNumber<Long> {

  ExpectToBeLong(Long actual) {
    super(actual);
  }

  @Override
  public void toBeLessThan(Long expected) {
    if (cannotBeCompared(expected) || actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Long expected) {
    if (cannotBeCompared(expected) || actual <= expected) {
      throw new IllegalArgumentException();
    }
  }

}
