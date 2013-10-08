package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeLongTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect(10L).toBe(10L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(10L).toBe(9L);
  }

  @Test
  public void To_Be_Less_Than() throws Exception {
    expect(1L).toBeLessThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11L).toBeLessThan(9L);
  }

  @Test
  public void To_Be_Greater_Than() throws Exception {
    expect(10L).toBeGreaterThan(9L);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1L).toBeGreaterThan(9L);
  }

  @Test
  public void When_Expected_To_Be_Greater_Than_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 to be greater than 10",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(5L).toBeGreaterThan(10L);
                   }
                 }));
  }

  @Test
  public void When_Expected_To_Be_Greater_Than_Null_Fails_Then_Exception_Should_Have_Message() throws Exception {
    assertEquals("Expected 5 to be greater than null",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(5L).toBeGreaterThan(null);
                   }
                 }));
  }
}
