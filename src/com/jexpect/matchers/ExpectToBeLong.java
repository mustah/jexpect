package com.jexpect.matchers;

import com.jexpect.ToBeLong;

class ExpectToBeLong implements ToBeLong {

  private final long actual;

  ExpectToBeLong(long actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(long expected) {
    if (actual != expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(long expected) {
    if (actual >= expected) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(long expected) {
    if (actual <= expected) {
      throw new IllegalArgumentException();
    }
  }
}
