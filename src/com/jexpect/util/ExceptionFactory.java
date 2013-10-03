package com.jexpect.util;

public final class ExceptionFactory {

  private ExceptionFactory() {
  }

  public static void throwNewIllegalArgumentException(String expected, String actual) {
    throw new IllegalArgumentException(createMessage(expected, actual));
  }

  public static void throwNewIllegalArgumentExceptionForNot(String expected, String actual) {
    throw new IllegalArgumentException(createMessageForNot(expected, actual));
  }

  public static String createMessage(String expected, String actual) {
    return "Expected to be " + expected + ", but found: " + actual;
  }

  public static String createMessageForNot(String expected, String actual) {
    return "Expected not to be " + expected + ", but found: " + actual;
  }
}
