package com.jexpect.util;

public final class ExceptionHandler {

  private ExceptionHandler() {
  }

  public static String getExceptionMessage(Command command) throws Exception {
    try {
      command.execute();
      throw new IllegalStateException("Exception should have been thrown, before reaching this point");
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
