package com.jexpect;

import java.util.Comparator;

import static com.jexpect.Exceptions.throwNewIllegalArgumentException;

class ExpectToBeNumber<N extends Number & Comparable<? super N>> implements ToBeNumber<N> {

  private final N actual;
  private final Comparator<N> comparator;

  ExpectToBeNumber(N actual, Comparator<N> comparator) {
    this.actual = actual;
    this.comparator = comparator;
  }

  @Override
  public void toBe(N expected) {
    if (!actual.equals(expected))
      throwNewIllegalArgumentException(actual, "==", expected);
  }

  @Override
  public void toBeLessThan(N expected) {
    if (expected == null || comparator.compare(actual, expected) >= 0)
      throwNewIllegalArgumentException(actual, "<", expected);
  }

  @Override
  public void toBeLessThanOrEqual(N expected) {
    if (expected == null || comparator.compare(actual, expected) > 0)
      throwNewIllegalArgumentException(actual, "<=", expected);
  }

  @Override
  public void toBeGreaterThan(N expected) {
    if (expected == null || comparator.compare(actual, expected) <= 0)
      throwNewIllegalArgumentException(actual, ">", expected);
  }

  @Override
  public void toBeGreaterThanOrEqual(N expected) {
    if (expected == null || comparator.compare(actual, expected) < 0)
      throwNewIllegalArgumentException(actual, ">=", expected);
  }

  @Override
  public ToBeNumber<N> not() {
    return new ExpectToBeNumberNot<N>(actual, comparator);
  }

  private static class ExpectToBeNumberNot<N extends Number & Comparable<? super N>> implements ToBeNumber<N> {

    private final N actual;
    private final Comparator<N> comparator;

    private ExpectToBeNumberNot(N actual, Comparator<N> comparator) {
      this.actual = actual;
      this.comparator = comparator;
    }

    @Override
    public void toBe(N expected) {
      if (expected == null || comparator.compare(actual, expected) == 0)
        throwNewIllegalArgumentException(actual, "!=", expected);
    }

    @Override
    public void toBeLessThan(N expected) {
      if (expected == null || comparator.compare(actual, expected) < 0)
        throwNewIllegalArgumentException(actual, "not to be <", expected);
    }

    @Override
    public void toBeLessThanOrEqual(N expected) {
      if (expected == null || comparator.compare(actual, expected) < 0)
        throwNewIllegalArgumentException(actual, "not to be <=", expected);
    }

    @Override
    public void toBeGreaterThan(N expected) {
      if (expected == null || comparator.compare(actual, expected) > 0)
        throwNewIllegalArgumentException(actual, "not to be >", expected);
    }

    @Override
    public void toBeGreaterThanOrEqual(N expected) {
      if (expected == null || comparator.compare(actual, expected) >= 0)
        throwNewIllegalArgumentException(actual, "not to be >=", expected);
    }

    @Override
    public ToBeNumber<N> not() {
      return new ExpectToBeNumber<N>(actual, comparator);
    }
  }
}
