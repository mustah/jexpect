package com.jexpect.matchers;

import com.jexpect.ToBeBoolean;
import com.jexpect.ToBeDouble;
import com.jexpect.ToBeFloat;
import com.jexpect.ToBeInteger;
import com.jexpect.ToBeLong;
import com.jexpect.ToBeString;

public final class ExpectFactory {

  private ExpectFactory() {
  }

  public static ToBeBoolean newToBeBoolean(boolean actual) {
    return new ExpectToBeBoolean(actual);
  }

  public static ToBeInteger newToBeInteger(int actual) {
    return new ExpectToBeInteger(actual);
  }

  public static ToBeString newToBeString(String actual) {
    return new ExpectToBeString(actual);
  }

  public static ToBeFloat newToBeFloat(float actual) {
    return new ExpectToBeFloat(actual);
  }

  public static ToBeDouble newToBeDouble(double actual) {
    return new ExpectToBeDouble(actual);
  }

  public static ToBeLong newToBeLong(Long actual) {
    return new ExpectToBeLong(actual);
  }
}
