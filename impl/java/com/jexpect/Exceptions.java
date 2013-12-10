package com.jexpect;

final class Exceptions {

  private Exceptions() {
  }

  public static <N extends Number> void throwNewIllegalArgumentException(N actual, String operand, N expected) {
    throw new IllegalArgumentException(String.format("Expected %s %s %s", actual, operand, expected));
  }

  public static void throwNewIllegalArgumentException(Object expected, Object actual) {
    throw new IllegalArgumentException(String.format("Expected to be %s, but found: %s", expected, actual));
  }

  public static void throwNewIllegalArgumentExceptionForNot(Object expected, Object actual) {
    throw new IllegalArgumentException(String.format("Expected not to be %s, but found: %s", expected, actual));
  }
}
