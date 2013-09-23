package com.jexpect;

import com.jexpect.matchers.ExpectToBeBoolean;
import com.jexpect.matchers.ExpectToBeDouble;
import com.jexpect.matchers.ExpectToBeFloat;
import com.jexpect.matchers.ExpectToBeInteger;
import com.jexpect.matchers.ExpectToBeLong;
import com.jexpect.matchers.ExpectToBeString;

public final class Expect {

  private Expect() {
  }

  public static ToBeBoolean expect(boolean actual) {
    return new ExpectToBeBoolean(actual);
  }

  public static ToBeString expect(String actual) {
    return new ExpectToBeString(actual);
  }

  public static ToBeNumber<Integer> expect(Integer actual) {
    return new ExpectToBeInteger(actual);
  }

  public static ToBeNumber<Float> expect(Float actual) {
    return new ExpectToBeFloat(actual);
  }

  public static ToBeNumber<Double> expect(Double actual) {
    return new ExpectToBeDouble(actual);
  }

  public static ToBeNumber<Long> expect(Long actual) {
    return new ExpectToBeLong(actual);
  }

}
