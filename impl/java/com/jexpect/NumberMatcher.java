package com.jexpect;

import java.util.Comparator;

class NumberMatcher<N extends Number & Comparable<? super N>> {

  private final N actual;
  private final Comparator<N> comparator;

  NumberMatcher(N actual, Comparator<N> comparator) {
    this.actual = actual;
    this.comparator = comparator;
  }

  N getActual() {
    return actual;
  }

  boolean isEqual(N expected) {
    return expected == null || comparator.compare(actual, expected) == 0;
  }

  boolean isNotEqual(N expected) {
    return expected == null || comparator.compare(actual, expected) != 0;
  }

  boolean isGreaterThanOrEqual(N expected) {
    return expected == null || comparator.compare(actual, expected) >= 0;
  }

  boolean isGreaterThan(N expected) {
    return expected == null || comparator.compare(actual, expected) > 0;
  }

  boolean isLessThanOrEqual(N expected) {
    return expected == null || comparator.compare(actual, expected) <= 0;
  }

  boolean isLessThan(N expected) {
    return expected == null || comparator.compare(actual, expected) < 0;
  }
}
