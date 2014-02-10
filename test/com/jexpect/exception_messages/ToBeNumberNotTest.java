package com.jexpect.exception_messages;

import org.junit.Test;

import com.jexpect.util.Command;

import static com.jexpect.Expect.expect;
import static com.jexpect.util.ExceptionHandler.getExceptionMessage;
import static junit.framework.Assert.assertEquals;

public class ToBeNumberNotTest {
  @Test
  public void Expected_To_Be_Same_To_Fail_Then_Exception_Message_Should_Be_Displayed() throws Exception {
    assertEquals("Expected <10.0> not to be <10.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(10d).not().toBe(10d);
      }
    }));
  }

  @Test
  public void Expected_Not_To_Be_Less_Than_To_Fail_Then_Exception_Message_Should_Be_Displayed() throws Exception {
    assertEquals("Expected <1.0> not to be < <5.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(1d).not().toBeLessThan(5d);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Less_Than_Or_Equal_To_Fail_Then_Exception_Message_Should_Be_Displayed() throws Exception {
    assertEquals("Expected <1.0> not to be <= <5.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(1d).not().toBeLessThanOrEqual(5d);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Greater_Than_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected <30.0> not to be > <10.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(30d).not().toBeGreaterThan(10d);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Greater_Than_Null_Value_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected <30.0> not to be > <null>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(30d).not().toBeGreaterThan(null);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Greater_Than_Or_Equal_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected <30.0> not to be >= <12.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(30d).not().toBeGreaterThanOrEqual(12d);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Greater_Than_Or_Equal_Than_Null_Value_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected <30.0> not to be >= <null>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(30d).not().toBeGreaterThanOrEqual(null);
      }
    }));
  }

  @Test
  public void Expect_Not_To_Be_Greater_Than_Or_Equal_Than_Same_Value_Should_Fail_And_Have_Error_Message() throws Exception {
    assertEquals("Expected <30.0> not to be >= <30.0>", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(30d).not().toBeGreaterThanOrEqual(30d);
      }
    }));
  }
}
