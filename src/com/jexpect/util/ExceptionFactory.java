package com.jexpect.util;

public final class ExceptionFactory {

  private ExceptionFactory() {
  }

  public static <N extends Number> void throwNewIllegalArgumentException(N actual, String operand, N expected) {
    throw new IllegalArgumentException(String.format("Expected %s %s %s", actual, operand, expected));
  }

  public static void throwNewIllegalArgumentException(String expected, String actual) {
    throw new IllegalArgumentException("Expected to be " + expected + ", but found: " + actual);
  }

  public static void throwNewIllegalArgumentExceptionForNot(String expected, String actual) {
    throw new IllegalArgumentException("Expected not to be " + expected + ", but found: " + actual);
  }

}
