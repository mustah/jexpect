package com.jexpect;

final class Exceptions {

  private Exceptions() {
  }

  static <N extends Number> void throwNewIllegalArgumentException(N actual, String operand, N expected) {
    throw new IllegalArgumentException(String.format("Expected %s %s %s", actual, operand, expected));
  }

  static void throwNewIllegalArgumentException(Object expected, Object actual) {
    throw new IllegalArgumentException(String.format("Expected to be %s, but found: %s", expected, actual));
  }

  static void throwNewIllegalArgumentExceptionForNot(Object expected, Object actual) {
    throw new IllegalArgumentException(String.format("Expected not to be <%s>, but found: <%s>", expected, actual));
  }
}
