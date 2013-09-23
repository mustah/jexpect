package com.jexpect;

import com.jexpect.matchers.ExpectFactory;

public final class Expect {

  private Expect() {
  }

  public static ToBeBoolean expect(boolean actual) {
    return ExpectFactory.newToBeBoolean(actual);
  }

  public static ToBeString expect(String actual) {
    return ExpectFactory.newToBeString(actual);
  }

  public static ToBeNumber<Integer> expect(Integer actual) {
    return ExpectFactory.newToBeInteger(actual);
  }

  public static ToBeNumber<Float> expect(Float actual) {
    return ExpectFactory.newToBeFloat(actual);
  }

  public static ToBeNumber<Double> expect(Double actual) {
    return ExpectFactory.newToBeDouble(actual);
  }

  public static ToBeNumber<Long> expect(Long actual) {
    return ExpectFactory.newToBeLong(actual);
  }

}
