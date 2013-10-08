package com.jexpect;

import org.junit.Test;

import static com.jexpect.ExceptionHandler.getMessage;
import static com.jexpect.Expect.expect;
import static junit.framework.Assert.assertEquals;

public class ToBeNumberNotTest {

  @Test
  public void Expected_Not_To_Be_Same_Should_Pass() throws Exception {
    expect(19d).not().toBe(9d);
    expect(8d).not().toBe(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Not_To_Be_Same_To_Fail_Then_Exception_Should_Be_Thrown() throws Exception {
    expect(9d).not().toBe(9d);
  }

  @Test
  public void Expected_To_Be_Same_To_Fail_Then_Exception_Message_Should_Be_Displayed() throws Exception {
    assertEquals("Expected 10.0 != 10.0",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(10d).not().toBe(10d);
                   }
                 }));
  }

  @Test
  public void Expected_Not_To_Be_Less_Than_Should_Pass() throws Exception {
    expect(5d).not().toBeLessThan(2d);
    expect(3d).not().toBeLessThan(2d);
    expect(3d).not().toBeLessThan(-2d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expected_Not_Be_Less_Than_To_Fail_Then_Exception_Should_Be_Thrown() throws Exception {
    expect(5d).not().toBeLessThan(10d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Given_Same_Values_When_Expected_Not_Be_Less_Than_To_Fail_Then_Exception_Should_Be_Thrown() throws Exception {
    expect(5d).not().toBeLessThan(5d);
  }

  @Test
  public void testName() throws Exception {
    assertEquals("Expected 1.0 not to be < 5.0",
                 getMessage(new Command() {
                   @Override
                   public void execute() {
                     expect(1d).not().toBeLessThan(5d);
                   }
                 }));
  }

}
