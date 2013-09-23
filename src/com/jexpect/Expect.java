package com.jexpect;

import com.jexpect.matchers.ExpectFactory;

public final class Expect {

  private Expect() {
  }

  public static ToBeBoolean expect(boolean actual) {
    return ExpectFactory.newToBeBoolean(actual);
  }

  public static ToBeInteger expect(int actual) {
    return ExpectFactory.newToBeInteger(actual);
  }

  public static ToBeFloat expect(float actual) {
    return ExpectFactory.newToBeFloat(actual);
  }

  public static ToBeDouble expect(double actual) {
    return ExpectFactory.newToBeDouble(actual);
  }

  public static ToBeLong expect(Long actual) {
    return ExpectFactory.newToBeLong(actual);
  }

  public static ToBeString expect(String actual) {
    return ExpectFactory.newToBeString(actual);
  }

}
