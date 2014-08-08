package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeFloatTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect(10f).toBe(10.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(12f).toBe(9f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail_When_Actual_Is_Null() throws Exception {
    expect(10f).toBe(null);
  }

  @Test
  public void To_Be_Less_Than() throws Exception {
    expect(1f).toBeLessThan(9.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(11f).toBeLessThan(9.0f);
  }

  @Test
  public void To_Be_Greater_Than() throws Exception {
    expect(10f).toBeGreaterThan(9.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(1f).toBeGreaterThan(9.0f);
  }
}
