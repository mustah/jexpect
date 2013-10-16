package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getExceptionMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeNumberTest {

  @Test
  public void When_Expected_To_Be_Greater_Than_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 > 10", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeGreaterThan(10L);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Greater_Than_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 > null", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeGreaterThan(null);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Less_Than_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 < 2", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeLessThan(2L);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Less_Than_To_Null_Value_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 < null", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeLessThan(null);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Same_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 == 100", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBe(100L);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Same_As_Null_Value_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 == null", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBe(null);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Less_Than_Or_Equals_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 <= 2", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeLessThanOrEqual(2L);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Less_Than_Or_Equals_To_Null_Value_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 <= null", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(5L).toBeLessThanOrEqual(null);
      }
    }));
  }

  @Test
  public void When_Expected_To_Be_Greater_Than_Or_Equals_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 2 >= 5", getExceptionMessage(new Command() {
      @Override
      public void execute() {
        expect(2L).toBeGreaterThanOrEqual(5L);
      }
    }));
  }
}
