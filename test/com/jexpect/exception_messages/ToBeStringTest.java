package com.jexpect.exception_messages;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;

public class ToBeStringTest {

  private static final String NULL_STRING = null;

  @Test
  public void When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be <>, but found: <foo>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect("foo").toBeEmpty();
      }
    }));
  }

  @Test
  public void Given_Null_When_Expected_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be <>, but found: <null>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_STRING).toBeEmpty();
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be <null>, but found: <foo>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect("foo").toBeNull();
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected to be <bar>, but found: <foo>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect("foo").toBe("bar");
      }
    }));
  }

  @Test
  public void When_Expected_Not_To_Be_As_Actual_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be <foo>, but found: <foo>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect("foo").not().toBe("foo");
      }
    }));
  }

  @Test
  public void When_Expected_Not_To_Be_Empty_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be <>, but found: <>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect("").not().toBeEmpty();
      }
    }));
  }

  @Test
  public void When_Expected_Not_Be_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected not to be <null>, but found: <null>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(NULL_STRING).not().toBeNull();
      }
    }));
  }
}
