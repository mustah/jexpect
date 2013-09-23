package com.jexpect.matchers;

import com.jexpect.ToBeNumber;

abstract class ExpectToBeNumber<N extends Number> implements ToBeNumber<N> {

  protected final N actual;

  protected ExpectToBeNumber(N actual) {
    this.actual = actual;
  }

  @Override
  public void toBe(N expected) {
    if (anyIsNull(expected) || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  protected boolean anyIsNull(N expected) {
    return actual == null || expected == null;
  }
}