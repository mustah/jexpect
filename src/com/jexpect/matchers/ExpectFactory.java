package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;
import com.jexpect.ToBeNumber;
import com.jexpect.ToBeString;

public final class ExpectFactory {

  private ExpectFactory() {
  }

  public static ToBeBoolean newToBeBoolean(boolean actual) {
    return new ExpectToBeBoolean(actual);
  }

  public static ToBeString newToBeString(String actual) {
    return new ExpectToBeString(actual);
  }

  public static ToBeNumber<Integer> newToBeInteger(Integer actual) {
    return new ExpectToBeInteger(actual);
  }

  public static ToBeNumber<Float> newToBeFloat(Float actual) {
    return new ExpectToBeFloat(actual);
  }

  public static ToBeNumber<Double> newToBeDouble(Double actual) {
    return new ExpectToBeDouble(actual);
  }

  public static ToBeNumber<Long> newToBeLong(Long actual) {
    return new ExpectToBeLong(actual);
  }
}
