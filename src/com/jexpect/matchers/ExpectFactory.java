package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;
import com.jexpect.ToBeInteger;

public final class ExpectFactory {

  private ExpectFactory() {
  }

  public static ToBeBoolean newToBoolean(boolean actual) {
    return new ExpectToBeBoolean(actual);
  }

  public static ToBeInteger newToInteger(int actual) {
    return new ExpectToBeInteger(actual);
  }
}
