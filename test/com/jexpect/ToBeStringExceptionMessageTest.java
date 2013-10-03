package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeStringExceptionMessageTest {

  @Test
  public void When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    final String actual = "foo";

    assertEquals("Expected to be empty, but found: " + actual,
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(actual).toBeEmpty();
                   }
                 }));

    final String nullString = null;

    assertEquals("Expected to be empty, but found: " + nullString,
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(nullString).toBeEmpty();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    final String actual = "foo";

    assertEquals("Expected to be null, but found: " + actual,
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(actual).toBeNull();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Fails_Then_Exception_Should_Have_Message() throws Exception {
    final String actual = "foo";
    final String expected = "bar";

    assertEquals("Expected to be " + expected + ", but found: " + actual,
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(actual).toBe(expected);
                   }
                 }));
  }

}
