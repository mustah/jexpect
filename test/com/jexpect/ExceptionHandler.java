package com.jexpect;

final class ExceptionHandler {

  private ExceptionHandler() {
  }

  static String getMessageWhenFailed(Command command) throws Exception {
    try {
      command.execute();
      throw new IllegalStateException("Exception should have been thrown, before reaching this point");
    } catch (Exception e) {
      return e.getMessage();
    }
  }

}
