package com.jexpect;

class StringMatcher {

  private final String str;

  StringMatcher(String str) {
    this.str = str;
  }

  boolean isEqualTo(String expected) {
    return str != null && str.equals(expected);
  }

  boolean isNotEqualTo(String expected) {
    return !isEqualTo(expected);
  }

  boolean isNotNull() {
    return str != null;
  }

  boolean isNull() {
    return str == null;
  }

  boolean isEmpty() {
    return str != null && str.isEmpty();
  }

  boolean isNotEmpty() {
    return !isEmpty();
  }

  String getActual() {
    return str;
  }
}
