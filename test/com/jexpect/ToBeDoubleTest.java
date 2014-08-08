package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeDoubleTest {

  @Test
  public void Expect_Should_Not_Throw_Exception() throws Exception {
    expect(3d).toBe(3d);
    expect(6d).toBeGreaterThan(3d);
    expect(1d).toBeLessThan(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(10d).toBe(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_When_Actual_Is_Null_Fail() throws Exception {
    expect(10d).toBe(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11d).toBeLessThan(9d);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1d).toBeGreaterThan(9d);
  }
}
