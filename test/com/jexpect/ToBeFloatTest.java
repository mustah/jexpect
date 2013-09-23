package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeFloatTest {

  @Test
  public void To_Be_Actual() throws Exception {
    expect(Float.valueOf(10)).toBe(10.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail() throws Exception {
    expect(Float.valueOf(12)).toBe(9f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Fail_When_Actual_Is_Null() throws Exception {
    expect(10.0f).toBe(null);
  }

  @Test
  public void To_Be_Less_Than() throws Exception {
    expect(Float.valueOf(1)).toBeLessThan(9.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Less_Than_Fail() throws Exception {
    expect(Float.valueOf(11)).toBeLessThan(9.0f);
  }

  @Test
  public void To_Be_Greater_Than() throws Exception {
    expect(Float.valueOf(10)).toBeGreaterThan(9.0f);
  }

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Greater_Than_Fail() throws Exception {
    expect(Float.valueOf(1)).toBeGreaterThan(9.0f);
  }
}
