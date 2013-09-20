package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeIntegerTest {

  @Test
  public void Expect_Number_To_Be_Less_Than_Should_Not_Throw() throws Exception {
    expect(10).toBeLessThan(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Number_To_Be_Less_Than_Should_Throw_When_Actual_And_Expected_Are_The_Same() throws Exception {
    expect(11).toBeLessThan(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Number_To_Be_Less_Than_Should_Throw() throws Exception {
    expect(12).toBeLessThan(11);
  }

  @Test
  public void Expect_Number_To_Be_Greater_Than_Should_Not_Throw() throws Exception {
    expect(12).toBeGreaterThan(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Number_To_Be_Greater_Than_Throw_When_Actual_And_Expected_Are_The_Same() throws Exception {
    expect(11).toBeGreaterThan(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Expect_Number_To_Be_Greater_Than_Should_Throw() throws Exception {
    expect(10).toBeGreaterThan(11);
  }
}
