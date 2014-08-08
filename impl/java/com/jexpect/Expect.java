package com.jexpect;

import java.util.Collection;
import java.util.Comparator;

public final class Expect {

  private Expect() {
  }

  private static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o1.compareTo(o2);
    }
  };

  private static final Comparator<Float> FLOAT_COMPARATOR = new Comparator<Float>() {
    @Override
    public int compare(Float o1, Float o2) {
      return o1.compareTo(o2);
    }
  };

  private static final Comparator<Double> DOUBLE_COMPARATOR = new Comparator<Double>() {
    @Override
    public int compare(Double o1, Double o2) {
      return o1.compareTo(o2);
    }
  };

  private static final Comparator<Long> LONG_COMPARATOR = new Comparator<Long>() {
    @Override
    public int compare(Long o1, Long o2) {
      return o1.compareTo(o2);
    }
  };

  public static ToBeBoolean expect(boolean actual) {
    return new ExpectToBeBoolean(actual);
  }

  public static ToBeString expect(String actual) {
    return new ExpectToBeString(new StringMatcher(actual));
  }

  public static ToBeNumber<Integer> expect(int actual) {
    return new ExpectToBeNumber<>(new NumberMatcher<>(actual, INTEGER_COMPARATOR));
  }

  public static ToBeNumber<Float> expect(float actual) {
    return new ExpectToBeNumber<>(new NumberMatcher<>(actual, FLOAT_COMPARATOR));
  }

  public static ToBeNumber<Double> expect(double actual) {
    return new ExpectToBeNumber<>(new NumberMatcher<>(actual, DOUBLE_COMPARATOR));
  }

  public static ToBeNumber<Long> expect(long actual) {
    return new ExpectToBeNumber<>(new NumberMatcher<>(actual, LONG_COMPARATOR));
  }

  public static <T> ToBeCollection<T> expect(Collection<T> actual) {
    return new ExpectToBeCollection<>(new CollectionMatcher<>(actual));
  }

  public static <T> ToBeCollection<T> expect(Iterable<T> actual) {
    return new ExpectToBeIterable<>(new IterableMatcher<>(actual));
  }
}
