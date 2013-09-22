package com.jexpect;

import org.junit.Test;

import static com.jexpect.Expect.expect;

public class ToBeLongTest {

  private static Long NULL_VALUE = null;

  @Test(expected = IllegalArgumentException.class)
  public void To_Be_Actual_Is_Null() throws Exception {
    expect(NULL_VALUE).toBe(10L);
  }

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
}
