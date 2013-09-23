package com.jexpect.matchers;

import com.jexpect.ToBeLong;

class ExpectToBeLong implements ToBeLong {

  private final Long actual;

  ExpectToBeLong(Long actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(Long expected) {
    if (actual == null && expected != null) {
      throw new IllegalArgumentException();
    } else if (actual != null && !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(Long expected) {
    if (actual == null && expected != null) {
      throw new IllegalArgumentException();
    } else if (actual != null && actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(Long expected) {
    if (actual == null && expected != null) {
      throw new IllegalArgumentException();
    } else if (actual != null && actual <= expected) {
      throw new IllegalArgumentException();
    }
  }
}
