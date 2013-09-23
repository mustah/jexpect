package com.jexpect.matchers;

import com.jexpect.ToBeLong;

class ExpectToBeLong implements ToBeLong {

  private final Long actual;

  ExpectToBeLong(Long actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Long expected) {
    if (cannotBeCompared(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
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

  private boolean cannotBeCompared(Long expected) {
    return actual == null || expected == null;
  }
}
