package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeStringExceptionMessageTest {

  @Test
  public void When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be empty, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBeEmpty();
                   }
                 }));
  }

  @Test
  public void Given_Null_When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    final String nullString = null;

    assertEquals("Expected to be empty, but found: null",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(nullString).toBeEmpty();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be null, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBeNull();
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be bar, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").toBe("bar");
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_To_Be_As_Actual_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be foo, but found: foo",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("foo").not().toBe("foo");
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be empty, but found: ",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect("").not().toBeEmpty();
                   }
                 }));
  }

  @Test
  public void When_Expected_Not_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be null, but found: null",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(null).not().toBeNull();
                   }
                 }));
  }
}
