package com.jexpect;

import static com.jexpect.Exceptions.throwNewIllegalArgumentException;

class ExpectToBeNumber<N extends Number & Comparable<? super N>> implements ToBeNumber<N> {

  private final NumberMatcher<N> matcher;

  ExpectToBeNumber(NumberMatcher<N> matcher) {
    this.matcher = matcher;
  }

  @Override
  public void toBe(N expected) {
    if (matcher.isNotEqual(expected)) {
      throwNewIllegalArgumentException(matcher.getActual(), "==", expected);
    }
  }

  @Override
  public void toBeLessThan(N expected) {
    if (matcher.isGreaterThanOrEqual(expected)) {
      throwNewIllegalArgumentException(matcher.getActual(), "<", expected);
    }
  }

  @Override
  public void toBeLessThanOrEqual(N expected) {
    if (matcher.isGreaterThan(expected)) {
      throwNewIllegalArgumentException(matcher.getActual(), "<=", expected);
    }
  }

  @Override
  public void toBeGreaterThan(N expected) {
    if (matcher.isLessThanOrEqual(expected)) {
      throwNewIllegalArgumentException(matcher.getActual(), ">", expected);
    }
  }

  @Override
  public void toBeGreaterThanOrEqual(N expected) {
    if (matcher.isLessThan(expected)) {
      throwNewIllegalArgumentException(matcher.getActual(), ">=", expected);
    }
  }

  @Override
  public ToBeNumber<N> not() {
    return new ExpectToBeNumberNot<>(matcher);
  }

  private static class ExpectToBeNumberNot<N extends Number & Comparable<? super N>> implements ToBeNumber<N> {

    private final NumberMatcher<N> matcher;

    private ExpectToBeNumberNot(NumberMatcher<N> matcher) {
      this.matcher = matcher;
    }

    @Override
    public void toBe(N expected) {
      if (matcher.isEqual(expected)) {
        throwNewIllegalArgumentException(matcher.getActual(), "not to be", expected);
      }
    }

    @Override
    public void toBeLessThan(N expected) {
      if (matcher.isLessThan(expected)) {
        throwNewIllegalArgumentException(matcher.getActual(), "not to be <", expected);
      }
    }

    @Override
    public void toBeLessThanOrEqual(N expected) {
      if (matcher.isLessThan(expected)) {
        throwNewIllegalArgumentException(matcher.getActual(), "not to be <=", expected);
      }
    }

    @Override
    public void toBeGreaterThan(N expected) {
      if (matcher.isGreaterThan(expected)) {
        throwNewIllegalArgumentException(matcher.getActual(), "not to be >", expected);
      }
    }

    @Override
    public void toBeGreaterThanOrEqual(N expected) {
      if (matcher.isGreaterThanOrEqual(expected)) {
        throwNewIllegalArgumentException(matcher.getActual(), "not to be >=", expected);
      }
    }

    @Override
    public ToBeNumber<N> not() {
      return new ExpectToBeNumber<>(matcher);
    }
  }
}
