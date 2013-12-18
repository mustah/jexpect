package com.jexpect.exception_messages;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static org.fest.assertions.api.Assertions.assertThat;

public class ToBeBooleanTest {

  @Test
  public void When_Expected_False_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertThat("Expected to be <false>, but found: <true>").isEqualTo(getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(true).toBeFalse();
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_True_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertThat("Expected to be <true>, but found: <false>").isEqualTo(getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(false).toBeTrue();
      }
    }));
  }

  @Test
  public void When_Expected_Actual_To_Be_Same_As_Expected_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertThat("Expected to be <true>, but found: <false>").isEqualTo(getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(false).toBe(true);
      }
    }));

    assertThat("Expected to be <false>, but found: <true>").isEqualTo(getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(true).toBe(false);
      }
    }));

    assertThat("Expected to be <null>, but found: <true>").isEqualTo(getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(true).toBe(null);
      }
    }));
  }
}
