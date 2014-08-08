package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeFloatTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(1.0f).toBe(1.0f);
    expect(1.0f).toBeLessThan(9.0f);
    expect(7.0f).toBeGreaterThan(4.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(12f).toBe(9f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail_When_Actual_Is_Null() throws Exception {
    expect(10f).toBe(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11f).toBeLessThan(9.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1f).toBeGreaterThan(9.0f);
  }
}
