package com.jexpect;

import com.jexpect.matchers.ExpectFactory;

public final class Expect {

  private Expect() {
  }

  public static ToBeBoolean expect(boolean actual) {
    return ExpectFactory.newToBoolean(actual);
  }

  public static ToBeInteger expect(int actual) {
    return ExpectFactory.newToInteger(actual);
  }

  public static ToBeFloat expect(float actual) {
    return ExpectFactory.newToFloat(actual);
  }

  public static ToBeString expect(String actual) {
    return ExpectFactory.newToString(actual);
  }

}
