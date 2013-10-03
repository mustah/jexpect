package com.jexpect.util;

public final class ExceptionFactory {

  private ExceptionFactory() {
  }

  public static void throwNewIllegalArgumentException(String expected, String actual) {
    throw new IllegalArgumentException(createMessage(expected, actual));
  }

  public static String createMessage(String expected, String actual) {
    return "Expected to be " + expected + ", but found: " + actual;
  }
}
