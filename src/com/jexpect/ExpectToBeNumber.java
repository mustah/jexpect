package com.jexpect;

import java.util.Comparator;

class ExpectToBeNumber<N extends Number & Comparable<? super N>> implements ToBeNumber<N> {

  private final N actual;
  private final Comparator<N> comparator;

  ExpectToBeNumber(N actual, Comparator<N> comparator) {
    this.actual = actual;
    this.comparator = comparator;
  }

  @Override
  public void toBe(N expected) {
    if (actual == null || !actual.equals(expected)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeLessThan(N expected) {
    if (actual == null || comparator.compare(actual, expected) >= 0) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void toBeGreaterThan(N expected) {
    if (actual == null || comparator.compare(actual, expected) <= 0) {
      throw new IllegalArgumentException();
    }
  }

}
